package com.bbraun.producto.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "hojas_de_ingreso")
public class HojaIngreso {

    @Id
    private String idhoja;
    private String idempleado;
    private Date fechaingreso;

}
