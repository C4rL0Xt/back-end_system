package com.bbraun.producto.models.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HojaIngresoDto {

    private String idhoja;
    private String idempleado;
    private Date fechaingreso;
    private List<DetalleHojaDto> detalles;
}
