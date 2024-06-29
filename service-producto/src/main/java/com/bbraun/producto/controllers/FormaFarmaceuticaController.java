package com.bbraun.producto.controllers;

import com.bbraun.producto.models.entity.FormaFarmaceutica;
import com.bbraun.producto.service.IFormaFarmaceuticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/formas")
public class FormaFarmaceuticaController {

    @Autowired
    private IFormaFarmaceuticaService formaFarmaceuticaService;



    @GetMapping("/lista")
    public List<FormaFarmaceutica> listarFormas(){
        return formaFarmaceuticaService.findAll();
    }


    @GetMapping("/for-com")
    public List<String> listarNombreForma(){
        return formaFarmaceuticaService.findFormaName();
    }
}
