package com.bbraun.producto.service;

import com.bbraun.producto.models.dto.ProductoDTO;
import com.bbraun.producto.models.entity.Categoria;
import com.bbraun.producto.models.entity.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> findAll();

    public Producto findById(String id);

    public Producto save(Producto producto);

    public void deleteById(String id);

    List<Producto> findByIdCategoria(Categoria categoria);

    List<Producto> findByNombre(String nombre);

    ProductoDTO findLotesDisponibles(String id);

}
