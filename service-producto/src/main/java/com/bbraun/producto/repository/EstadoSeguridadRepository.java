package com.bbraun.producto.repository;

import com.bbraun.producto.models.entity.EstadoSeguridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoSeguridadRepository extends JpaRepository<EstadoSeguridad,Integer> {

    EstadoSeguridad findByEstado(String estado);

    @Query("select e.estado from EstadoSeguridad e")
    List<String> findAllByEstado();
}
