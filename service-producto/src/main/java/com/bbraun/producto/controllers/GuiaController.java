package com.bbraun.producto.controllers;

import com.bbraun.producto.models.entity.GuiaRemision;
import com.bbraun.producto.service.IGuiaRemision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guias")
public class GuiaController {

    @Autowired
    private IGuiaRemision guiaRemisionService;

    @GetMapping("/listar")
    public List<GuiaRemision> listar(){
        return guiaRemisionService.findAll();
    }

    @GetMapping("/lastcode")
    public String lastCode(){
        return guiaRemisionService.getLastCode();
    }

    @PostMapping("/save")
    public GuiaRemision save(@RequestBody GuiaRemision guiaRemision){
        return guiaRemisionService.save(guiaRemision);
    }

    @PutMapping("/update")
    public GuiaRemision update(@RequestBody GuiaRemision guiaRemision){
        return guiaRemisionService.updateGuia(guiaRemision);
    }

}
