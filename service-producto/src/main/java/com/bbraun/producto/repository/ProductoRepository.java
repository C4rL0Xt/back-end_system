package com.bbraun.producto.repository;

import com.bbraun.producto.models.dto.ProductoPresentationDto;
import com.bbraun.producto.models.entity.Categoria;
import com.bbraun.producto.models.entity.Producto;
import com.bbraun.producto.models.proyeccion.ProductoProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository<Producto,String> {


    List<Producto> findAll();

    List<Producto> findByIdCategoria(Categoria categoria);

    @Query("select u from Producto u where u.nombre= ?1")
    List<Producto> findByNombre(String nombre);

    @Query("SELECT p.idProducto from Producto p order by p.idProducto desc")
    List<String> getLastCodeProducto();

    Producto findByNombreAndAndConcentracion(String nombre, String concentracion);

}
