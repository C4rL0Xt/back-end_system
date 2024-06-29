package com.bbraun.producto.models.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "productos")
@NoArgsConstructor
@Builder
public class Producto {

    @Id
    @Column(name = "idProducto")
    private String idProducto;

    @OneToOne
    @JoinColumn(name = "id_categoria")
    private Categoria idCategoria;
    @OneToOne
    @JoinColumn(name = "id_forma_farmaceutica")
    private FormaFarmaceutica idFormaFarmaceutica;
    private String idAlmacen;
    private String nombre;
    private Float precio;
    private String concentracion;
    private String presentacion;
    private String descripcion;


    public Producto(String idProducto, Categoria idCategoria, FormaFarmaceutica idFormaFarmaceutica, String idAlmacen, String nombre, Float precio, String concentracion, String presentacion, String descripcion) {
        this.idProducto = idProducto;
        this.idCategoria = idCategoria;
        this.idFormaFarmaceutica = idFormaFarmaceutica;
        this.idAlmacen = idAlmacen;
        this.nombre = nombre;
        this.precio = precio;
        this.concentracion = concentracion;
        this.presentacion = presentacion;
        this.descripcion = descripcion;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public FormaFarmaceutica getIdFormaFarmaceutica() {
        return idFormaFarmaceutica;
    }

    public void setIdFormaFarmaceutica(FormaFarmaceutica idFormaFarmaceutica) {
        this.idFormaFarmaceutica = idFormaFarmaceutica;
    }

    public String getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(String idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
