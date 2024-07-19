package com.bbraun.documentos.compra.servicecompra.services;

import com.bbraun.documentos.compra.servicecompra.models.dto.SolicitudCompraDto;
import com.bbraun.documentos.compra.servicecompra.models.entity.SolicitudCompra;

import java.util.List;

public interface ISolicitudCompraService {

    public List<SolicitudCompra> findAll();

    public String findLastCode();

    public List<SolicitudCompraDto> findSolicitudWithEstado();

    public SolicitudCompra save(SolicitudCompraDto dto);

    public SolicitudCompra updateSolicitudCompra(SolicitudCompraDto dto);

    public List<SolicitudCompraDto> findSolicitudPendiente();

    public SolicitudCompra updateState(String idSolicitud, Integer estado);

}
