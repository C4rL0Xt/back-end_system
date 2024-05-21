package com.bbraun.producto.controllers;

import com.bbraun.producto.models.entity.Categoria;
import com.bbraun.producto.models.entity.Producto;
import com.bbraun.producto.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/lista")
    public List<Producto> listarProductos(){
        return (List<Producto>) productoService.findAll();
    }

    @GetMapping("/categoria/{idcategoria}")
    public List<Producto> listarProductosPorCategoria(@PathVariable("idcategoria") String idcategoria){
        Categoria categoria = new Categoria();
        categoria.setId_categoria(idcategoria);
        return productoService.findByIdCategoria(categoria);
    }

    @GetMapping("/buscar/{idproducto}")
    public Producto verProductoPorId(@PathVariable("idproducto") String idproducto){
        return productoService.findById(idproducto);
    }


}
