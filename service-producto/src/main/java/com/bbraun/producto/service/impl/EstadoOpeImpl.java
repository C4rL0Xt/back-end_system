package com.bbraun.producto.service.impl;

import com.bbraun.producto.models.entity.EstadoOperativo;
import com.bbraun.producto.repository.EstadoOperativoRepository;
import com.bbraun.producto.service.IEstadoOpeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoOpeImpl implements IEstadoOpeService {

    @Autowired
    private EstadoOperativoRepository estadoOperativoRepository;

    @Override
    public List<EstadoOperativo> findAll() {
        return estadoOperativoRepository.findAll();
    }

    @Override
    public EstadoOperativo findByEstado(String estado) {


        return estadoOperativoRepository.findByEstado(estado);
    }

    @Override
    public List<String> findAllEstados() {
        return estadoOperativoRepository.findAllByEstado();
    }
}
