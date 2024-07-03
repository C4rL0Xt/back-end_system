package com.bbraun.producto.models.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleHojaDto {

    private String idproducto;
    private int cantidad;
    private String nombreProducto;

}
