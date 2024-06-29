package com.bbraun.producto.service;

import com.bbraun.producto.models.entity.EstadosDisponibilidad;

import java.util.List;

public interface IEstadoDispService {

    List<EstadosDisponibilidad> findAll();

    EstadosDisponibilidad findByEstado(String estado);

    List<String> findAllEstados();
}
