package com.bbraun.producto.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@IdClass(DetalleHojaId.class) // uso de la clase para la clave primaria compuesta
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "detalles_hoja_ingreso")
public class DetalleHoja {


    @Id
    private String idhoja;
    @Id
    private String idproducto;
    private int cantidad;


}
