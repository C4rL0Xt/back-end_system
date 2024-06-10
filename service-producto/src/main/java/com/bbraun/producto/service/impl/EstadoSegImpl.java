package com.bbraun.producto.service.impl;

import com.bbraun.producto.models.entity.EstadoSeguridad;
import com.bbraun.producto.repository.EstadoSeguridadRepository;
import com.bbraun.producto.service.IEstadoSegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoSegImpl implements IEstadoSegService {

    @Autowired
    EstadoSeguridadRepository estadoSeguridadRepository;

    @Override
    public List<EstadoSeguridad> findAll() {
        return estadoSeguridadRepository.findAll();
    }
}
