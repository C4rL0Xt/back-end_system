package com.bbraun.producto.service.impl;


import com.bbraun.producto.models.dto.LoteDTO;
import com.bbraun.producto.models.dto.LotePresentationDto;
import com.bbraun.producto.models.dto.ProductoDTO;
import com.bbraun.producto.models.dto.ProductoPresentationDto;
import com.bbraun.producto.models.entity.FormaFarmaceutica;
import com.bbraun.producto.models.entity.Lote;
import com.bbraun.producto.models.proyeccion.LoteProjection;
import com.bbraun.producto.models.proyeccion.ProductoProjection;
import com.bbraun.producto.repository.ProductoRepository;
import com.bbraun.producto.models.entity.Categoria;
import com.bbraun.producto.models.entity.Producto;
import com.bbraun.producto.service.ICategoriaService;
import com.bbraun.producto.service.IFormaFarmaceuticaService;
import com.bbraun.producto.service.ILoteService;
import com.bbraun.producto.service.IProductoService;
import com.bbraun.producto.util.LoteConverter;
import com.bbraun.producto.util.ProductoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoRepository productoDAO;

    @Autowired
    private ILoteService loteService;

    @Autowired
    private ICategoriaService categoriaService;

    @Autowired
    private IFormaFarmaceuticaService formaFarmaceuticaService;

    @Autowired
    private ProductoConverter productoConverter;
    @Autowired
    private LoteConverter loteConverter;


    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) productoDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(String id) {
        return productoDAO.findById(id).orElse(null);
    }

    @Override
    public Producto save(Producto producto) {
        return productoDAO.save(producto);
    }

    @Override
    public void deleteById(String id) {
        productoDAO.deleteById(id);
    }


    @Override
    public ProductoPresentationDto findByNombreAndAndConcentracion(String nombre, String concentracion) {
        System.out.println("Este es el nombre: "+nombre+" concn: "+concentracion);
        Producto producto = productoDAO.findByNombreAndAndConcentracion(nombre,concentracion);
        System.out.println("Este producto obtengo: "+producto.getNombre());
        ProductoPresentationDto productoDTO = new ProductoPresentationDto();
        productoDTO.setConcentracion(producto.getConcentracion());
        productoDTO.setName(producto.getNombre());
        productoDTO.setPrice(producto.getPrecio());
        productoDTO.setCode(producto.getIdProducto());
        return productoDTO;
    }

    @Override
    public List<Producto> findByIdCategoria(Categoria categoria) {
        return (List<Producto>) productoDAO.findByIdCategoria(categoria);
    }

    @Override
    public List<Producto> findByNombre(String nombre) {
        return (List<Producto>)productoDAO.findByNombre(nombre);
    }

    @Override
    public ProductoDTO findLotesDisponibles(String idproducto) {
        Optional<Producto> producto = productoDAO.findById(idproducto);
        List<Lote> lotes_disponibles = loteService.findLotesDisponiblesPorProductoId(idproducto,"Disponible");
        List<LoteDTO> lote_productos = new ArrayList<>();
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setNombre(producto.get().getNombre());
        for(int i = 0 ; i<lotes_disponibles.size(); i++){
            LoteDTO loteDTO = new LoteDTO();
            loteDTO.setStock(lotes_disponibles.get(i).getStock());
            loteDTO.setEstado(lotes_disponibles.get(i).getEstadosDisponibilidad().getEstado());
            lote_productos.add(loteDTO);
        }
        productoDTO.setLotes(lote_productos);
        return productoDTO;
    }

    @Override
    public List<ProductoPresentationDto> findAllWithLots() {
        List<ProductoPresentationDto> productos_table = new ArrayList<>();
        List<Producto> pro = productoDAO.findAll();

        for (Producto producto : pro) {
            ProductoPresentationDto dto = new ProductoPresentationDto();
            dto.setCode(producto.getIdProducto());
            dto.setCategory(producto.getIdCategoria().getCategoria());
            dto.setType(producto.getIdFormaFarmaceutica().getForma());
            dto.setDescription(producto.getDescripcion());
            dto.setPrice(producto.getPrecio());
            dto.setConcentracion(producto.getConcentracion());
            dto.setName(producto.getNombre());
            dto.setPresentation(producto.getPresentacion());
            List<Lote> lotes = loteService.findLotesByProductoId(producto.getIdProducto());
            List<LotePresentationDto> lots = new ArrayList<>();
            for (Lote lote: lotes){

                LotePresentationDto lotedto = new LotePresentationDto();
                lotedto.setCode(lote.getIdlote());
                lotedto.setOperativeStatus(lote.getEstadoOperativo().getEstado());
                lotedto.setDisponibilityState(lote.getEstadosDisponibilidad().getEstado());
                lotedto.setSecurityState(lote.getEstadoSeguridad().getEstado());
                lotedto.setStock(lote.getStock());
                lotedto.setExpiredDate(lote.getFechavencimiento());
                lots.add(lotedto);
            }
            dto.setLots(lots);

            productos_table.add(dto);
        }
        return productos_table;
    }

    @Override
    public String getLastCodeProducto() {
        List<String> productos = productoDAO.getLastCodeProducto();
        return productos.get(0);
    }

    @Override
    @Transactional
    public Producto createProductoWithLots(ProductoPresentationDto dto) {
        Categoria categoria = categoriaService.findByName(dto.getCategory());
        FormaFarmaceutica forma = formaFarmaceuticaService.findByName(dto.getType());

        Producto producto = productoConverter.convertToEntity(dto, categoria, forma);
        Producto savedProducto = productoDAO.save(producto);

        List<Lote> lotes = loteConverter.convertLoteDtoToEntityLote(dto.getLots(), savedProducto);
        loteService.saveAll(lotes);

        return savedProducto;
    }

    @Override
    @Transactional
    public Producto updateProductoWithLots( ProductoPresentationDto dto) {
        Producto producto = productoDAO.findById(dto.getCode()).orElse(null);

        Categoria categoria = categoriaService.findByName(dto.getCategory());
        FormaFarmaceutica forma = formaFarmaceuticaService.findByName(dto.getType());

        if(producto == null){
            throw new RuntimeException("Producto no encontrado");
        }

        producto = (Producto) productoConverter.convertToEntity(dto, categoria, forma);
        Producto updateProducto = productoDAO.save(producto);

        List<Lote> lotes = loteConverter.convertLoteDtoToEntityLote(dto.getLots(), updateProducto);
        loteService.saveAll(lotes);


        return updateProducto;
    }

    @Override
    public ProductoPresentationDto findProductoWithLots(String id) {
        Producto producto = productoDAO.findById(id).orElse(null);
        if(producto == null){
            throw new RuntimeException("Producto no encontrado");
        }
        ProductoPresentationDto dto = new ProductoPresentationDto();
        dto.setCode(producto.getIdProducto());
        dto.setCategory(producto.getIdCategoria().getCategoria());
        dto.setType(producto.getIdFormaFarmaceutica().getForma());
        dto.setDescription(producto.getDescripcion());
        dto.setPrice(producto.getPrecio());
        dto.setConcentracion(producto.getConcentracion());
        dto.setName(producto.getNombre());
        dto.setPresentation(producto.getPresentacion());
        List<Lote> lotes = loteService.findLotesByProductoId(id);
        List<LotePresentationDto> lots = new ArrayList<>();
        for (Lote lote: lotes){

            LotePresentationDto lotedto = new LotePresentationDto();
            lotedto.setCode(lote.getIdlote());
            lotedto.setOperativeStatus(lote.getEstadoOperativo().getEstado());
            lotedto.setDisponibilityState(lote.getEstadosDisponibilidad().getEstado());
            lotedto.setSecurityState(lote.getEstadoSeguridad().getEstado());
            lotedto.setStock(lote.getStock());
            lotedto.setExpiredDate(lote.getFechavencimiento());
            lots.add(lotedto);
        }
        dto.setLots(lots);
        return dto;
    }
}
