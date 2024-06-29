package com.bbraun.empleado.serviceempleado.services;

import com.bbraun.empleado.serviceempleado.models.dto.EmpleadoDto;
import com.bbraun.empleado.serviceempleado.models.entity.Empleado;

import java.util.List;

public interface IEmpleadoService {

    EmpleadoDto findEmpleadoByEmail(String email);

    List<Empleado> findAll();
}
