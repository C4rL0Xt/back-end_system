package com.bbraun.empleado.serviceempleado.repository;

import com.bbraun.empleado.serviceempleado.models.entity.Empleado;
import com.bbraun.empleado.serviceempleado.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, String> {

    Empleado findByCuenta(Usuario cuenta);
}
