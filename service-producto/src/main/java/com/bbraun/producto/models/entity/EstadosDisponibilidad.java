package com.bbraun.producto.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "estados_disponibilidad")
public class EstadosDisponibilidad {

    @Id
    private Integer idestadodisponibilidad;
    private String estado;
}
