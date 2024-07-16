package com.bbraun.empleado.serviceempleado.services;

import com.bbraun.empleado.serviceempleado.models.dto.EmpleadoDto;
import com.bbraun.empleado.serviceempleado.models.dto.TransportistaDTO;
import com.bbraun.empleado.serviceempleado.models.entity.Empleado;
import com.bbraun.empleado.serviceempleado.models.entity.Transportista;

import java.util.List;

public interface IEmpleadoService {

    EmpleadoDto findEmpleadoByEmail(String email);

    List<Empleado> findAll();

    List<TransportistaDTO> listarTransportista();
}
