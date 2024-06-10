package com.bbraun.producto.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@Entity
@Table(name = "lotes")
public class Lote {

    @Id
    private String idlote;
    @OneToOne
    @JoinColumn(name = "idestadooperativo")
    private EstadoOperativo estadoOperativo;
    @OneToOne
    @JoinColumn(name = "idestadodisponibilidad")
    private EstadosDisponibilidad estadosDisponibilidad;
    @OneToOne
    @JoinColumn(name = "idestadoseguridad")
    private EstadoSeguridad estadoSeguridad;
    @OneToOne
    @JoinColumn(name = "idproducto")
    private Producto producto;
    private Integer stock;
    private Date fechavencimiento;
}
