package com.bbraun.producto.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "formas_farmaceuticas")
public class FormaFarmaceutica {

    @Id
    private String id_forma_farmaceutica;
    private String forma;

    public String getId_forma_farmaceutica() {
        return id_forma_farmaceutica;
    }

    public void setId_forma_farmaceutica(String id_forma_farmaceutica) {
        this.id_forma_farmaceutica = id_forma_farmaceutica;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }
}
