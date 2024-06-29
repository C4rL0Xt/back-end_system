package com.bbraun.producto.models.proyeccion;

import java.util.Date;

public interface LoteProjection {
    String getIdLote();
    String getEstadoOperativo();
    String getEstadoDisponibilidad();
    String getEstadoSeguridad();
    Integer getStock();
    Date getFechaVencimiento();
}
