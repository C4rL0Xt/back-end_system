package com.bbraun.producto.service.impl;

import com.bbraun.producto.models.entity.EstadosDisponibilidad;
import com.bbraun.producto.repository.EstadoDisponibilidadRepository;
import com.bbraun.producto.service.IEstadoDispService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoDispImpl implements IEstadoDispService {

    @Autowired
    private EstadoDisponibilidadRepository estadoDisponibilidadRepository;

    @Override
    public List<EstadosDisponibilidad> findAll() {
        return estadoDisponibilidadRepository.findAll();
    }

    @Override
    public EstadosDisponibilidad findByEstado(String estado) {
        return estadoDisponibilidadRepository.findByEstado(estado);
    }

    @Override
    public List<String> findAllEstados() {
        return estadoDisponibilidadRepository.findAllByEstado();
    }
}
