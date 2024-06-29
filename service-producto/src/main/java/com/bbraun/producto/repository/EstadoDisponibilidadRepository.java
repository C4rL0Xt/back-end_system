package com.bbraun.producto.repository;

import com.bbraun.producto.models.entity.EstadosDisponibilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoDisponibilidadRepository extends JpaRepository<EstadosDisponibilidad,Integer> {

    EstadosDisponibilidad findByEstado(String estado);

    @Query("select e.estado from EstadosDisponibilidad e")
    List<String> findAllByEstado();
}
