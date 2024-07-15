package com.bbraun.proveedor.service;

import com.bbraun.proveedor.models.entity.Proveedor;
import com.bbraun.proveedor.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorImpl implements IProveedorService{

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> listarPorOrden(){
        return (List<Proveedor>) proveedorRepository.listarPorOrden();
    }

}

