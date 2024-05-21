package com.bbraun.producto.models.dao;

import com.bbraun.producto.models.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaDAO extends CrudRepository<Categoria,String> {
}
