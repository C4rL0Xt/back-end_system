package com.bbraun.producto.repository;

import com.bbraun.producto.models.entity.DetalleHoja;
import com.bbraun.producto.models.entity.DetalleHojaId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleHojaRepository extends JpaRepository<DetalleHoja, DetalleHojaId>{

    public List<DetalleHoja> findAllByIdhoja(String idhoja);
}
