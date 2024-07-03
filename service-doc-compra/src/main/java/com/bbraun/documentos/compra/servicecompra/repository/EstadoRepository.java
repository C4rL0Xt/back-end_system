package com.bbraun.documentos.compra.servicecompra.repository;

import com.bbraun.documentos.compra.servicecompra.models.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

    @Query("SELECT e FROM Estado e WHERE e.estado = ?1")
    Estado findByEstado(String estado);
}
