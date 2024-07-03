package com.bbraun.producto.repository;

import com.bbraun.producto.models.entity.GuiaRemision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GuiaRemisionRepository extends JpaRepository<GuiaRemision, String> {
    @Query(value = "SELECT g.idGuiaRemision FROM guias_remision g ORDER BY g.idGuiaRemision desc ", nativeQuery = true)
    List<String> getLastCode();
}
