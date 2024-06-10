package com.bbraun.producto.service.impl;


import com.bbraun.producto.models.dto.LoteDTO;
import com.bbraun.producto.models.dto.ProductoDTO;
import com.bbraun.producto.models.entity.Lote;
import com.bbraun.producto.repository.ProductoRepository;
import com.bbraun.producto.models.entity.Categoria;
import com.bbraun.producto.models.entity.Producto;
import com.bbraun.producto.service.ILoteService;
import com.bbraun.producto.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoRepository productoDAO;

    @Autowired
    private ILoteService loteService;


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
}
