package com.bbraun.producto.repository;

import com.bbraun.producto.models.entity.EstadoOperativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoOperativoRepository extends JpaRepository<EstadoOperativo, Integer> {

    EstadoOperativo findByEstado(String estado);

    @Query("select e.estado from EstadoOperativo e")
    List<String> findAllByEstado();
}
