package com.bbraun.proveedor.service;

import com.bbraun.proveedor.models.dto.ProveedorDTO;
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

    @Override
    public Proveedor getProveedorById(String idproveedor){
        return proveedorRepository.findByIdproveedor(idproveedor);
    }

    @Override
    public Proveedor getProveedorByNombre(String nombre){
        return proveedorRepository.findByEmpresa(nombre);
    }

    @Override
    public Proveedor saveProveedor(ProveedorDTO dto){
        Proveedor proveedor = Proveedor.builder()
                .idproveedor(dto.getIdproveedor())
                .empresa(dto.getEmpresa())
                .direccion(dto.getDireccion())
                .telefono(dto.getTelefono())
                .email(dto.getEmail())
                .rate(dto.getRate())
                .ruc(dto.getRuc())
                .build();
        return proveedorRepository.save(proveedor);
    }
}

