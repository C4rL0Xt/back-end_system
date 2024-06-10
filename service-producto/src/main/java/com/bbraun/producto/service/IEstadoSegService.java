package com.bbraun.producto.service;

import com.bbraun.producto.models.entity.EstadoSeguridad;

import java.util.List;

public interface IEstadoSegService {


    List<EstadoSeguridad> findAll();
}
