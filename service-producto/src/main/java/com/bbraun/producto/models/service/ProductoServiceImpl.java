package com.bbraun.producto.models.service;

import com.bbraun.producto.models.dao.ProductoDAO;
import com.bbraun.producto.models.entity.Categoria;
import com.bbraun.producto.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private ProductoDAO productoDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) productoDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(String id) {
        return productoDAO.findById(id).orElse(null);
    }

    @Override
    public Producto save(Producto producto) {
        return productoDAO.save(producto);
    }

    @Override
    public void deleteById(String id) {
        productoDAO.deleteById(id);
    }

    @Override
    public List<Producto> findByIdCategoria(Categoria categoria) {
        return (List<Producto>) productoDAO.findByIdCategoria(categoria);
    }
}
