package com.bbraun.pedidos.cotizacion.models.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CotizacionDtoPDF {
    private String idcotizacion;
    private String estado;
    private String cliente;
    private Float monto_producto;
    private Date fecha_emision;
    private String email;
    private Float monto_impuesto;
    private Float monto_total;
    private String departamento;
    private List<DetalleDtoPDF> detalles;

}
