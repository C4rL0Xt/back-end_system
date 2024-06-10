package com.bbraun.producto.repository;

import com.bbraun.producto.models.entity.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria,String> {
}
