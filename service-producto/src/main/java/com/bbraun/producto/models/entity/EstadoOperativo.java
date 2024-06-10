package com.bbraun.producto.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "estados_operativos")
public class EstadoOperativo {

    @Id
    private Integer idestadooperativo;
    private String estado;
}
