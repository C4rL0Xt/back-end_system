package com.bbraun.producto.service;

import com.bbraun.producto.models.entity.EstadoOperativo;

import java.util.List;

public interface IEstadoOpeService {

    List<EstadoOperativo> findAll();

    EstadoOperativo findByEstado(String estado);

    List<String> findAllEstados();
}
