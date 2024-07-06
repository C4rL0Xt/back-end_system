package com.bbraun.pedidos.cotizacion.services.impl;

import com.bbraun.pedidos.cotizacion.models.Producto;
import com.bbraun.pedidos.cotizacion.models.dto.CotizacionDtoPDF;
import com.bbraun.pedidos.cotizacion.models.dto.CotizacionVentaDTO;
import com.bbraun.pedidos.cotizacion.models.dto.DetalleCotizacionVentaDTO;
import com.bbraun.pedidos.cotizacion.models.dto.DetalleDtoPDF;
import com.bbraun.pedidos.cotizacion.models.entity.CotizacionVenta;
import com.bbraun.pedidos.cotizacion.models.entity.Departamento;
import com.bbraun.pedidos.cotizacion.models.entity.DetalleCotizacionVenta;
import com.bbraun.pedidos.cotizacion.models.entity.Estado;
import com.bbraun.pedidos.cotizacion.repository.CotizacionVentaRepository;
import com.bbraun.pedidos.cotizacion.repository.DepartamentoRepository;
import com.bbraun.pedidos.cotizacion.repository.DetalleCVentaRepository;
import com.bbraun.pedidos.cotizacion.repository.EstadoRepository;
import com.bbraun.pedidos.cotizacion.services.ICotizacionVService;
import com.bbraun.pedidos.cotizacion.util.ConverToEntity;
import com.bbraun.pedidos.cotizacion.util.ConverterToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class CotizacionVentaImpl implements ICotizacionVService {

    @Autowired
    private CotizacionVentaRepository cotizacionVentaRepository;

    @Autowired
    private DetalleCVentaRepository detalleCotizacionVentaRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ConverterToDto converterToDto;

    @Autowired
    private ConverToEntity converToEntity;
    @Override
    public List<CotizacionVenta> findAll() {
        return cotizacionVentaRepository.findAll();
    }

    @Override
    public CotizacionVenta findById(String id) {
        return cotizacionVentaRepository.findById(id).orElse(null   );
    }


    @Override
    public String lastCode() {
        return cotizacionVentaRepository.findLastCode().get(0);
    }

    @Override
    public List<CotizacionVentaDTO> findAllWithDetails() {
        List<CotizacionVentaDTO> cotizacionVentaDTOS = new ArrayList<>();
        List<CotizacionVenta> cotizacionVentas = cotizacionVentaRepository.findAll();

        for(CotizacionVenta cotizacionVenta : cotizacionVentas){
            CotizacionVentaDTO cotizacionVentaDTO = CotizacionVentaDTO.builder()
                    .idcotizacion(cotizacionVenta.getId_cotizacion())
                    .idempleado(cotizacionVenta.getId_empleado())
                    .estado(cotizacionVenta.getEstado().getEstado())
                    .nombrecliente(cotizacionVenta.getNombre_cliente())
                    .montoproducto(cotizacionVenta.getMonto_producto())
                    .fechaemision(cotizacionVenta.getFecha_emision())
                    .email(cotizacionVenta.getEmail())
                    .montoimpuesto(cotizacionVenta.getMonto_impuesto())
                    .montototal(cotizacionVenta.getMonto_total())
                    .departamento(cotizacionVenta.getId_departamento().getNombreDepartamento())
                    .build();
            List<DetalleCotizacionVenta> detalles = detalleCotizacionVentaRepository.findAllByIdcotizacion(cotizacionVenta.getId_cotizacion());
            List<DetalleCotizacionVentaDTO> details_dto = new ArrayList<>();
            for(DetalleCotizacionVenta detail: detalles){
                Producto producto = restTemplate.getForObject("http://localhost:9000/api/almacen/producto/buscar-producto/"+detail.getIdproducto(),Producto.class);
                DetalleCotizacionVentaDTO detallaDto = DetalleCotizacionVentaDTO.builder()
                        .idcotizacion(detail.getIdcotizacion())
                        .producto(producto.getName())
                        .cantidad(detail.getCantidad())
                    .build();
                details_dto.add(detallaDto);
            }
            cotizacionVentaDTO.setDetalles(details_dto);
            cotizacionVentaDTOS.add(cotizacionVentaDTO);

        }
        return cotizacionVentaDTOS;
    }

    @Override
    public List<CotizacionDtoPDF> findAllCotizaciones() {
        List<CotizacionVenta> cotizacionVentas = cotizacionVentaRepository.findAll();


        List<CotizacionDtoPDF> cotizacionDtos = new ArrayList<>();


        for (int i = 0; i < cotizacionVentas.size(); i++) {
            List<DetalleDtoPDF> detalleDtos = new ArrayList<>();
            List<DetalleCotizacionVenta> detalles = new ArrayList<>();
            detalles = detalleCotizacionVentaRepository.findAllByIdcotizacion(cotizacionVentas.get(i).getId_cotizacion());
            for (int j = 0; j < detalles.size() ; j++) {
                Producto producto = restTemplate.getForObject("http://localhost:9000/api/almacen/producto/buscar-producto/"+detalles.get(j).getIdproducto(),Producto.class);
                DetalleDtoPDF detalleDto = converterToDto.converterDetallVToDto(detalles.get(j),producto);
                detalleDtos.add(detalleDto);
            }
            CotizacionDtoPDF cotizacionDto = converterToDto.convertCotizacionEntityToDto(cotizacionVentas.get(i),detalleDtos);
            cotizacionDtos.add(cotizacionDto);
        }
        return cotizacionDtos;
    }

    @Override
    public CotizacionVenta createCotizacionVentaWithDetails(CotizacionVentaDTO cotizacionVentaDTO) {
        Estado estado = estadoRepository.findByEstado(cotizacionVentaDTO.getEstado());
        Departamento departamento = departamentoRepository.findByNombreDepartamento(cotizacionVentaDTO.getDepartamento());
        CotizacionVenta cotizacionVenta = converToEntity.convertToEntityCotizacionVenta(cotizacionVentaDTO,estado,departamento);
        CotizacionVenta cotizacionSaved = cotizacionVentaRepository.save(cotizacionVenta);
        List<DetalleCotizacionVenta> detalles = converToEntity.converToEntityDetalleVenta(cotizacionVentaDTO.getDetalles(),cotizacionVenta);
        detalleCotizacionVentaRepository.saveAll(detalles);
        return cotizacionSaved;
    }

    @Override
    public CotizacionVentaDTO calculateMontos(CotizacionVentaDTO cotizacionVentaDTO) {

        Float montoproducto = 0.0f;
        for (DetalleCotizacionVentaDTO detalle: cotizacionVentaDTO.getDetalles()) {
            String url = UriComponentsBuilder.fromHttpUrl("http://localhost:9000/api/almacen/producto/buscar-producto")
                    .queryParam("nombre", detalle.getProducto())
                    .queryParam("concentracion", detalle.getConcentracion())
                    .toUriString();

            System.out.println("URL: " + url);
            Producto producto = (Producto) restTemplate.getForObject(url, Producto.class);
            if (producto != null && producto.getPrice() != null) {
                montoproducto += producto.getPrice() * detalle.getCantidad();
            } else {
                // Manejar el caso donde el producto no se encuentra
                // Puedes lanzar una excepción o manejar de otra manera apropiada
                System.out.println("Producto no encontrado");
            }
        }

        Float montoimpuesto = montoproducto/18;
        Float montototal = montoimpuesto + montoproducto;

        CotizacionVentaDTO dto = CotizacionVentaDTO.builder()
                .montoproducto(montoproducto)
                .montoimpuesto(montoimpuesto)
                .montototal(montototal)
                .build();

        return dto;
    }
}
