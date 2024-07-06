package com.bbraun.pedidos.cotizacion.models.dto;

import com.bbraun.pedidos.cotizacion.models.Producto;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleDtoPDF {
    private Producto producto;
    private Integer cantidad;
}
