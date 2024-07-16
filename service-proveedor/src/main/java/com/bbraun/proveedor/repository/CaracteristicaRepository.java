package com.bbraun.proveedor.repository;

import com.bbraun.proveedor.models.entity.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaracteristicaRepository extends JpaRepository<Caracteristica, Integer> {
}
