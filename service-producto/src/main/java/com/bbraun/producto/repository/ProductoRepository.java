package com.bbraun.producto.repository;

import com.bbraun.producto.models.entity.Categoria;
import com.bbraun.producto.models.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository<Producto,String> {

    List<Producto> findByIdCategoria(Categoria categoria);

    @Query("select u from Producto u where u.nombre= ?1")
    List<Producto> findByNombre(String nombre);
}
