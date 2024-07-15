package com.bbraun.proveedor.controllers;

import com.bbraun.proveedor.models.entity.Proveedor;
import com.bbraun.proveedor.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
    @Autowired
    private IProveedorService proveedorService;

    @GetMapping("/listarPOrden")
    public List<Proveedor> listarProvedoresPorOrdenDeRate(){
        return (List<Proveedor>) proveedorService.listarPorOrden();
    }

}
