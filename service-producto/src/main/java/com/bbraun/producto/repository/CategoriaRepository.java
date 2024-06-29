package com.bbraun.producto.repository;

import com.bbraun.producto.models.entity.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria,String> {

    @Query("SELECT c.categoria FROM Categoria c")
    List<String> findAllCategories();

    Categoria findCategoriaByCategoria(String categoria);
}
