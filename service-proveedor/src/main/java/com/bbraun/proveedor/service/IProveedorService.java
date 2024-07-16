package com.bbraun.proveedor.service;

import com.bbraun.proveedor.models.dto.ProveedorDTO;
import com.bbraun.proveedor.models.entity.Proveedor;

import java.util.List;

public interface IProveedorService {

    public List<Proveedor> listarPorOrden();

    public Proveedor getProveedorById(String idproveedor);

    public Proveedor getProveedorByNombre(String nombre);

    public Proveedor saveProveedor(ProveedorDTO dto);
}
