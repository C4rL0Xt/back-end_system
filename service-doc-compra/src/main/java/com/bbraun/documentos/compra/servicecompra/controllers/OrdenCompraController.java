package com.bbraun.documentos.compra.servicecompra.controllers;

import com.bbraun.documentos.compra.servicecompra.models.dto.OrdenCompraDto;
import com.bbraun.documentos.compra.servicecompra.models.entity.OrdenCompra;
import com.bbraun.documentos.compra.servicecompra.services.IOrdenCompraService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordencompra")
public class OrdenCompraController {

    @Autowired
    private IOrdenCompraService ordenCompraService;

    @GetMapping("/all")
    public List<OrdenCompraDto> findAll(){
        return ordenCompraService.findAll();
    }

    @PostMapping("/save")
    public OrdenCompra save(@RequestBody OrdenCompraDto dto){
        return ordenCompraService.save(dto);
    }
}
