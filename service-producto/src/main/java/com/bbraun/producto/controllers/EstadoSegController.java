package com.bbraun.producto.controllers;

import com.bbraun.producto.models.entity.EstadoSeguridad;
import com.bbraun.producto.service.IEstadoSegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estado-seguridad")
public class EstadoSegController {

    @Autowired
    private IEstadoSegService estadoSegService;

    @GetMapping("/listar")
    public List<EstadoSeguridad> listarEstados(){
        return (List<EstadoSeguridad>) estadoSegService.findAll();
    }
}
