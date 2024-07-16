package com.bbraun.empleado.serviceempleado.repository;

import com.bbraun.empleado.serviceempleado.models.dto.TransportistaDTO;
import com.bbraun.empleado.serviceempleado.models.entity.Empleado;
import com.bbraun.empleado.serviceempleado.models.entity.Transportista;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransportistaRepository extends JpaRepository<Transportista, String> {
    @Query("select t from Transportista t where t.estado = 'inactivo'")
    List<Transportista> listarActivos();

    @Modifying
    @Transactional
    @Query("update Transportista t set t.estado = :estado where t.idempleado = :idempleado")
    void actualizarEstadoPorIdEmpleado(String idempleado, String estado);

}
