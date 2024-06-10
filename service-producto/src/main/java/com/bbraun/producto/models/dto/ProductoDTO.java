package com.bbraun.producto.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductoDTO {
    private String nombre;
    private List<LoteDTO> lotes;
}
