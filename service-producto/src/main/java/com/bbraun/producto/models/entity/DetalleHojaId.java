package com.bbraun.producto.models.entity;


/*Clave primaria compuesta en la tabla detallehoja, es necesario crear un clase para
* las claves compuestas*/


import java.io.Serializable;

public class DetalleHojaId implements Serializable {

    private String idhoja;
    private String idproducto;

}
