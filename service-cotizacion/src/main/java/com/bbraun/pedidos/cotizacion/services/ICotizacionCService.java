package com.bbraun.pedidos.cotizacion.services;

import com.bbraun.pedidos.cotizacion.models.dto.SolicitudCotizacionDTO;
import com.bbraun.pedidos.cotizacion.models.entity.SolicitudCotizacionCompra;

import java.util.List;

public interface ICotizacionCService {

    public List<SolicitudCotizacionCompra> findAll();

    public List<SolicitudCotizacionDTO> findAllDTO();
}
