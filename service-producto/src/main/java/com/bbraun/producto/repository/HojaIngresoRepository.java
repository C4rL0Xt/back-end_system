package com.bbraun.producto.repository;

import com.bbraun.producto.models.entity.HojaIngreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HojaIngresoRepository extends JpaRepository<HojaIngreso, String> {

    @Query("SELECT h.idhoja from HojaIngreso h order by h.idhoja desc")
    List<String> getLastCodeHoja();

    HojaIngreso findByIdhoja(String idhoja);
}
