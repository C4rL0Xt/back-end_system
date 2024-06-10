package com.bbraun.producto.controllers;


import com.bbraun.producto.models.dto.LoteDTO;
import com.bbraun.producto.models.dto.ProductoDTO;
import com.bbraun.producto.models.entity.Categoria;
import com.bbraun.producto.models.entity.Lote;
import com.bbraun.producto.models.entity.Producto;
import com.bbraun.producto.service.ILoteService;
import com.bbraun.producto.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private ILoteService loteService;

    @GetMapping("/listar")
    public List<Producto> listarProductos(){
        return (List<Producto>) productoService.findAll();
    }

    @GetMapping("/buscar-categoria/{idcategoria}")
    public List<Producto> listarProductosPorCategoria(@PathVariable("idcategoria") String idcategoria){
        Categoria categoria = new Categoria();
        categoria.setId_categoria(idcategoria);
        return productoService.findByIdCategoria(categoria);
    }

    @GetMapping("/buscar-id/{idproducto}")
    public Producto verProductoPorId(@PathVariable("idproducto") String idproducto){
        return productoService.findById(idproducto);
    }

    @GetMapping("/buscar-nombre/{nombreproducto}")
    public List<Producto> verProductoPorNombre(@PathVariable("nombreproducto") String nombreproducto){
        return (List<Producto>)productoService.findByNombre(nombreproducto);
    }

    @GetMapping("/ver-lotes-dis/{idproducto}")
    public ProductoDTO getLotesDisponiblesPorLote(@PathVariable("idproducto") String idproducto){

        return  productoService.findLotesDisponibles(idproducto);
    }
}
