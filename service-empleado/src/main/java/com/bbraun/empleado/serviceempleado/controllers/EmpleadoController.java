package com.bbraun.empleado.serviceempleado.controllers;

import com.bbraun.empleado.serviceempleado.models.dto.EmpleadoDto;
import com.bbraun.empleado.serviceempleado.models.dto.TransportistaDTO;
import com.bbraun.empleado.serviceempleado.models.entity.Empleado;
import com.bbraun.empleado.serviceempleado.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {


    @Autowired
    private IEmpleadoService empleadoService;




    @GetMapping("/data/{email}")
    public ResponseEntity<EmpleadoDto> getEmpleadoPorEmail(@PathVariable String email){
        EmpleadoDto empleadoDto = empleadoService.findEmpleadoByEmail(email);
        return ResponseEntity.ok(empleadoDto);
    }

    @GetMapping("/all")
    public List<Empleado> getEmpleados(){
        return (List<Empleado>) empleadoService.findAll();
    }

    @GetMapping("/listarActivos")
    public List<TransportistaDTO> listarActivos(){
        return (List<TransportistaDTO>) empleadoService.listarTransportista();
    }
}
