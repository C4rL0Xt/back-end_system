package com.bbraun.producto.repository;

import com.bbraun.producto.models.entity.EstadosDisponibilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoDisponibilidadRepository extends JpaRepository<EstadosDisponibilidad,Integer> {

}
