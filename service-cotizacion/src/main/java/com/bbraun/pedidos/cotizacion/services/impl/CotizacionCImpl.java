package com.bbraun.pedidos.cotizacion.services.impl;

import com.bbraun.pedidos.cotizacion.models.dto.DetalleCotizacionCompraDTO;
import com.bbraun.pedidos.cotizacion.models.dto.SolicitudCotizacionDTO;
import com.bbraun.pedidos.cotizacion.models.entity.DetalleCotizacionCompra;
import com.bbraun.pedidos.cotizacion.models.entity.SolicitudCotizacionCompra;
import com.bbraun.pedidos.cotizacion.repository.DetalleCotizacionCompraRepository;
import com.bbraun.pedidos.cotizacion.repository.SolicitudCotizacionRepository;
import com.bbraun.pedidos.cotizacion.services.ICotizacionCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CotizacionCImpl implements ICotizacionCService{

    @Autowired
    private SolicitudCotizacionRepository solicitudCotizacionRepository;

    @Autowired
    private DetalleCotizacionCompraRepository detalleCotizacionCompraRepository;

    @Override
    public List<SolicitudCotizacionCompra> findAll() {
        return solicitudCotizacionRepository.findAll();
    }

    @Override
    public List<SolicitudCotizacionDTO> findAllDTO() {
        List<SolicitudCotizacionCompra> solicitudes = solicitudCotizacionRepository.findAll();
        List<SolicitudCotizacionDTO> solicitudesDTO = new ArrayList<>();

        solicitudes.stream().forEach(solicitud -> {
            SolicitudCotizacionDTO solicitudDTO = SolicitudCotizacionDTO.builder()
                            .idsolicitudcompra(solicitud.getIdSolicitudCompra())
                                    .idsolicitudcotizacion(solicitud.getIdSolicitudCotizacion())
                                            .fechacreacion(solicitud.getFechacreacion())
                    .detalles(converToDetalleSolicitudDto(detalleCotizacionCompraRepository.findAllByIdSolicitudCotizacion(solicitud.getIdSolicitudCotizacion())))
                    .build();
            solicitudesDTO.add(solicitudDTO);
        });

        return solicitudesDTO;
    }

    private List<DetalleCotizacionCompraDTO> converToDetalleSolicitudDto(List<DetalleCotizacionCompra> dtos){
        List<DetalleCotizacionCompraDTO> detalles = new ArrayList<>();
        dtos.stream().forEach(dto -> {
            DetalleCotizacionCompraDTO detalle = DetalleCotizacionCompraDTO.builder()
                    .idsolicitudcotizacion(dto.getIdSolicitudCotizacion())
                    .idproveedor(dto.getIdProveedor())
                    .build();
            detalles.add(detalle);
        });
        return detalles;
    }
}
