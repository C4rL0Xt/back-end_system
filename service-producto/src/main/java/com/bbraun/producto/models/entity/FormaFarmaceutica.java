package com.bbraun.producto.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "formas_farmaceuticas")
public class FormaFarmaceutica {

    @Id
    private String id_forma_farmaceutica;
    private String forma;

}
