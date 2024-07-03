package com.bbraun.documentos.compra.servicecompra.services.impl;

import com.bbraun.documentos.compra.servicecompra.models.dto.SolicitudCompraDto;
import com.bbraun.documentos.compra.servicecompra.models.entity.Estado;
import com.bbraun.documentos.compra.servicecompra.models.entity.SolicitudCompra;
import com.bbraun.documentos.compra.servicecompra.repository.EstadoRepository;
import com.bbraun.documentos.compra.servicecompra.repository.SolicitudCompraRepository;
import com.bbraun.documentos.compra.servicecompra.services.ISolicitudCompraService;
import com.bbraun.documentos.compra.servicecompra.util.ConverterToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitudServiceImpl implements ISolicitudCompraService {

    @Autowired
    private SolicitudCompraRepository solicitudCompraRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ConverterToEntity converterToEntity;

    @Override
    public List<SolicitudCompra> findAll() {
        return solicitudCompraRepository.findAll();
    }

    @Override
    public String findLastCode() {
        return solicitudCompraRepository.getLastCodeSolicitudCompra().get(0);
    }

    @Override
    public List<SolicitudCompraDto> findSolicitudWithEstado() {
        List<Object[]> list = solicitudCompraRepository.findAllWithEstado();

        return list.stream().map( result -> SolicitudCompraDto.builder()
                .id_solicitud((String) result[0])
                .estado((String) result[1])
                .identificacion((String) result[2])
                .nombreProducto((String) result[3])
                .cantidadRequerida((Integer) result[4])
                .plazoEntrega((java.util.Date) result[5])
                .build())
                .collect(Collectors.toList());
    }

    @Override
    public SolicitudCompra save(SolicitudCompraDto dto) {
        Estado estado = estadoRepository.findByEstado(dto.getEstado());

            SolicitudCompra solicitudCompra = SolicitudCompra.builder()
                    .idsolicitudcompra(dto.getId_solicitud())
                    .estado(estado)
                    .idasistentecompra(dto.getIdentificacion())
                    .nombreproducto(dto.getNombreProducto())
                    .cantidad(dto.getCantidadRequerida())
                    .fecha_entrega(dto.getPlazoEntrega())
                    .idasistentealmacen(dto.getCodigoempleado())
                    .build();
            return solicitudCompraRepository.save(solicitudCompra);
    }

    @Override
    public SolicitudCompra updateSolicitudCompra(SolicitudCompraDto dto) {
        SolicitudCompra solicitudCompra = solicitudCompraRepository.findById(dto.getId_solicitud()).orElse(null);
        Estado estado = estadoRepository.findByEstado(dto.getEstado());

        solicitudCompra = (SolicitudCompra) converterToEntity.convertToEntity(dto, estado);

        return solicitudCompraRepository.save(solicitudCompra);
    }
}
