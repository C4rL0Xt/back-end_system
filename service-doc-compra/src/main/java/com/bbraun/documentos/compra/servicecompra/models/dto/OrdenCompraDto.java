package com.bbraun.documentos.compra.servicecompra.models.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdenCompraDto {
    private String id_orden_compra;
    private String id_solicitud_cotizacion;
    private String id_proveedor;
    private Date fecha_emision;
}
