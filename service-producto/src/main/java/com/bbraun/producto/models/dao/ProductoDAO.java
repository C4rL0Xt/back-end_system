package com.bbraun.producto.models.dao;

import com.bbraun.producto.models.entity.Categoria;
import com.bbraun.producto.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductoDAO extends CrudRepository<Producto,String> {

    List<Producto> findByIdCategoria(Categoria categoria);
}
