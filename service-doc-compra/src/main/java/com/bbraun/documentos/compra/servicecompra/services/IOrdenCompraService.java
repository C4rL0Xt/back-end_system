package com.bbraun.documentos.compra.servicecompra.services;

import com.bbraun.documentos.compra.servicecompra.models.dto.OrdenCompraDto;
import com.bbraun.documentos.compra.servicecompra.models.entity.OrdenCompra;

import java.util.List;

public interface IOrdenCompraService {

    List<OrdenCompraDto> findAll();

    OrdenCompra save(OrdenCompraDto dto);

}
