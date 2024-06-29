package com.bbraun.producto.util;

import com.bbraun.producto.models.dto.LotePresentationDto;
import com.bbraun.producto.models.entity.Lote;
import com.bbraun.producto.models.entity.Producto;
import com.bbraun.producto.service.IEstadoDispService;
import com.bbraun.producto.service.IEstadoOpeService;
import com.bbraun.producto.service.IEstadoSegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoteConverter {

    @Autowired
    private IEstadoSegService estadoSegService;

    @Autowired
    private IEstadoDispService estadoDispService;

    @Autowired
    private IEstadoOpeService estadoOpeService;


    public List<Lote> convertLoteDtoToEntityLote(List<LotePresentationDto> lotedto, Producto producto){
        return lotedto.stream().map(dto -> Lote.builder()
                .idlote(dto.getCode())
                .estadoOperativo(estadoOpeService.findByEstado(dto.getOperativeStatus()))
                .estadosDisponibilidad(estadoDispService.findByEstado(dto.getDisponibilityState()))
                .estadoSeguridad(estadoSegService.findByEstado(dto.getSecurityState()))
                .producto(producto)
                .stock(dto.getStock())
                .fechavencimiento(dto.getExpiredDate())
                .build()).collect(Collectors.toList());
    }
}
