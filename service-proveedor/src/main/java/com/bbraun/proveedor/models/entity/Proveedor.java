package com.bbraun.proveedor.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "proveedores")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proveedor {
    @Id
    private String idproveedor;
    private Integer idcaracteristica;
    private String empresa;
    private String direccion;
    private String telefono;
    private String email;
    private String ruc;
    private Integer rate;

}
