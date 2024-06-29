package com.bbraun.producto.controllers;

import com.bbraun.producto.models.entity.Lote;
import com.bbraun.producto.service.ILoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lotes")
public class LoteController {

    @Autowired
    private ILoteService loteService;

    @GetMapping("/listar")
    public List<Lote> listarLotes(){
        return (List<Lote>) loteService.findAll();
    }


    @GetMapping("/buscar/{idproducto}")
    public List<Lote> listarLotesPorProducto(@PathVariable("idproducto") String idproducto){

        return (List<Lote>) loteService.findLotesByProductoId(idproducto);
    }


    @GetMapping("/last-code")
    public String getLastCodeLote(){
        return loteService.getLastCodeLote();
    }
}
