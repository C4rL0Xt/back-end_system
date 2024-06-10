package com.bbraun.producto.repository;

import com.bbraun.producto.models.entity.EstadoOperativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoOperativoRepository extends JpaRepository<EstadoOperativo, Integer> {
}
