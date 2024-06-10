package com.bbraun.producto.repository;

import com.bbraun.producto.models.entity.EstadoSeguridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoSeguridadRepository extends JpaRepository<EstadoSeguridad,Integer> {
}
