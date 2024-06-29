package com.bbraun.producto.controllers;

import com.bbraun.producto.models.entity.EstadoOperativo;
import com.bbraun.producto.models.entity.EstadoSeguridad;
import com.bbraun.producto.models.entity.EstadosDisponibilidad;
import com.bbraun.producto.service.IEstadoDispService;
import com.bbraun.producto.service.IEstadoOpeService;
import com.bbraun.producto.service.IEstadoSegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoSegController {

    @Autowired
    private IEstadoSegService estadoSegService;

    @Autowired
    private IEstadoOpeService estadoOpeService;

    @Autowired
    private IEstadoDispService estadoDispService;


    @GetMapping("/s-listar")
    public List<String> listarEstadosSeguridad(){
        return estadoSegService.findAllEstados();
    }


    @GetMapping("/d-listar")
    public List<String> listarEstadosDisponibilidad() {
        return estadoDispService.findAllEstados();
    }


    @GetMapping("/o-listar")
    public List<String> listarEstadosOperativos() {
    return estadoOpeService.findAllEstados();
    }
}
