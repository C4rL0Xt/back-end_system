package com.bbraun.producto.models.service;

import com.bbraun.producto.models.entity.Categoria;
import com.bbraun.producto.models.entity.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> findAll();

    public Producto findById(String id);

    public Producto save(Producto producto);

    public void deleteById(String id);

    List<Producto> findByIdCategoria(Categoria categoria);
}
