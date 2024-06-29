package com.bbraun.producto.models.proyeccion;

import java.util.Date;
import java.util.List;

public interface ProductoProjection {
    String getIdProducto();
    String getCategoria();
    String getForma();
    String getNombre();
    Float getPrecio();
    String getConcentracion();
    String getPresentacion();
    String getDescripcion();
    List<LoteProjection> getLotes();

}
