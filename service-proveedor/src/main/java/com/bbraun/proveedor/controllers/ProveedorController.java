package com.bbraun.proveedor.controllers;

import com.bbraun.proveedor.models.dto.ProveedorDTO;
import com.bbraun.proveedor.models.entity.Proveedor;
import com.bbraun.proveedor.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
    @Autowired
    private IProveedorService proveedorService;

    @GetMapping("/listarOrden")
    public List<Proveedor> listarProvedoresPorOrdenDeRate(){
        return (List<Proveedor>) proveedorService.listarPorOrden();
    }

    @GetMapping("/get/{id}")
    public Proveedor getProveedorById(@PathVariable String id){
        return proveedorService.getProveedorById(id);
    }

    @GetMapping("/getByNombre/{nombre}")
    public Proveedor getProveedorByNombre(@PathVariable String nombre){
        return proveedorService.getProveedorByNombre(nombre);
    }

    @PutMapping("/save")
    public Proveedor saveProveedor(@RequestBody ProveedorDTO proveedor){
        return proveedorService.saveProveedor(proveedor);
    }

    @PostMapping("/create")
    public Proveedor createProveedor(@RequestBody ProveedorDTO proveedor){
        return proveedorService.saveProveedor(proveedor);
    }
}
