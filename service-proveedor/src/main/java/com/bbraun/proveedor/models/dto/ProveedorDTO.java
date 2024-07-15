package com.bbraun.proveedor.models.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProveedorDTO {
    private String idproveedor;
    private Integer idcaracteristica;
    private String empresa;
    private String direccion;
    private String telefono;
    private String email;
    private String ruc;
    private Integer rate;
}
