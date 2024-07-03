package com.bbraun.documentos.compra.servicecompra.models.dto;

import lombok.*;

import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolicitudCompraDto {
    private String id_solicitud;
    private String nombreProducto;
    private Integer cantidadRequerida;
    private Date plazoEntrega;
    private String identificacion; //asis compra
    private String estado;
    private String codigoempleado;
}
