package com.bbraun.pedidos.cotizacion.controllers;

import com.bbraun.pedidos.cotizacion.models.dto.SolicitudCotizacionDTO;
import com.bbraun.pedidos.cotizacion.models.entity.DetalleCotizacionCompra;
import com.bbraun.pedidos.cotizacion.models.entity.SolicitudCotizacionCompra;
import com.bbraun.pedidos.cotizacion.services.ICotizacionCService;
import com.bbraun.pedidos.cotizacion.services.IDetalleSolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coti-c")
public class CotizacionCompraController {

    @Autowired
    private ICotizacionCService cotizacionCService;

    @Autowired
    private IDetalleSolicitudService detalleSolicitudService;


    @GetMapping("/all")
    public List<SolicitudCotizacionCompra> findAll() {
        return cotizacionCService.findAll();
    }

    @GetMapping("/details")
    public List<DetalleCotizacionCompra> findAllDetails() {
        return detalleSolicitudService.findAll();
    }

    @GetMapping("/all-dto")
    public List<SolicitudCotizacionDTO> findAllDTO() {
        return cotizacionCService.findAllDTO();
    }

}
