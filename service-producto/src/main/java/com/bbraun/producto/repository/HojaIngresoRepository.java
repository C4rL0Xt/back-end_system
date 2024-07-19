package com.bbraun.producto.repository;

import com.bbraun.producto.models.dto.HojaIngresoDto;
import com.bbraun.producto.models.entity.HojaIngreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface HojaIngresoRepository extends JpaRepository<HojaIngreso, String> {

    @Query("SELECT h.idhoja from HojaIngreso h order by h.idhoja desc")
    List<String> getLastCodeHoja();

    HojaIngreso findByIdhoja(String idhoja);

    @Query(value = "SELECT h.idHoja,h.fechaIngreso, d.idProducto,d.cantidad,p.nombre " +
            "FROM dbo.hojas_de_ingreso h " +
            "JOIN dbo.detalles_hoja_ingreso d ON h.idHoja = d.idHoja " +
            "JOIN dbo.productos p ON d.idProducto = p.id_producto",nativeQuery = true)
    List<Object[]> findAllWithDetails();

    HojaIngreso findByFechaingreso(Date fechaingreso);
}
