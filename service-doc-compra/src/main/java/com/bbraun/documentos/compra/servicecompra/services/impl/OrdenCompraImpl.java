package com.bbraun.documentos.compra.servicecompra.services.impl;

import com.bbraun.documentos.compra.servicecompra.models.Proveedor;
import com.bbraun.documentos.compra.servicecompra.models.dto.OrdenCompraDto;
import com.bbraun.documentos.compra.servicecompra.models.entity.OrdenCompra;
import com.bbraun.documentos.compra.servicecompra.repository.OrdenCompraRepository;
import com.bbraun.documentos.compra.servicecompra.services.IOrdenCompraService;
import com.bbraun.documentos.compra.servicecompra.util.CodigoGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdenCompraImpl implements IOrdenCompraService {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Autowired
    private CodigoGeneratorService codigoGeneratorService;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public List<OrdenCompraDto> findAll() {
        List<OrdenCompra> ordenCompraList = ordenCompraRepository.findAll();
        List<OrdenCompraDto> ordenCompraDtoList = new ArrayList<>();

        ordenCompraList.forEach(ordenCompra -> {
            OrdenCompraDto ordenCompraDto = OrdenCompraDto.builder()
                    .id_orden_compra(ordenCompra.getIdordencompra())
                    .id_solicitud_cotizacion(ordenCompra.getIdsolicitudcotizacion())
                    .id_proveedor(ordenCompra.getIdproveedor())
                    .fecha_emision(ordenCompra.getFechaemision())
                    .build();
            ordenCompraDtoList.add(ordenCompraDto);
        });
        return ordenCompraDtoList;
    }

    @Override
    public OrdenCompra save(OrdenCompraDto dto) {
        //el dto trae el nombre del proveedor, hay una confusion de atributos ya que reutilizo el mismo modelo
        //al igual con el idsolicitudcotizacion, en el dto trae el de solicitud de compra, hay error de valor nms
        Proveedor proveedor = restTemplate.getForObject("http://localhost:9000/api/proveedor/proveedor/getByNombre/"+dto.getId_proveedor(), Proveedor.class);
        String codigo_coti = restTemplate.getForObject("http://localhost:9000/api/cotizacion/coti-c/code/"+dto.getId_solicitud_cotizacion(), String.class);
        OrdenCompra ordenCompra = OrdenCompra.builder()
                .idordencompra(codigoGeneratorService.generateCodigo())
                .idsolicitudcotizacion(codigo_coti)
                .idproveedor(proveedor.getIdproveedor())
                .fechaemision(dto.getFecha_emision())
                .build();
        return ordenCompraRepository.save(ordenCompra);
    }
}
