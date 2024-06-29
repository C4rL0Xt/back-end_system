package com.bbraun.producto.service;

import com.bbraun.producto.models.entity.EstadoSeguridad;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEstadoSegService {


    List<EstadoSeguridad> findAll();

    EstadoSeguridad findByEstado(String estado);


    List<String> findAllEstados();
}
