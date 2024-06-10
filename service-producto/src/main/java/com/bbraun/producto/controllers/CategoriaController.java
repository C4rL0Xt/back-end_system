package com.bbraun.producto.controllers;

import com.bbraun.producto.models.entity.Categoria;
import com.bbraun.producto.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/lista")
    public List<Categoria> listarCategorias(){
        return categoriaService.findAll();
    }
}
