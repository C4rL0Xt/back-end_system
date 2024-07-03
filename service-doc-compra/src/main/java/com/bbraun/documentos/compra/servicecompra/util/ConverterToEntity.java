package com.bbraun.documentos.compra.servicecompra.util;

import com.bbraun.documentos.compra.servicecompra.models.dto.SolicitudCompraDto;
import com.bbraun.documentos.compra.servicecompra.models.entity.Estado;
import com.bbraun.documentos.compra.servicecompra.models.entity.SolicitudCompra;
import org.springframework.stereotype.Component;

@Component
public class ConverterToEntity {
    public SolicitudCompra convertToEntity(SolicitudCompraDto dto, Estado estado) {
        SolicitudCompra solicitudCompra = SolicitudCompra.builder()
                .idsolicitudcompra(dto.getId_solicitud())
                .estado(estado)
                .idasistentealmacen(dto.getCodigoempleado())
                .fecha_entrega(dto.getPlazoEntrega())
                .cantidad(dto.getCantidadRequerida())
                .idasistentecompra(dto.getIdentificacion())
                .nombreproducto(dto.getNombreProducto())
                .build();
        return solicitudCompra;
    }
}
