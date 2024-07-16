package com.bbraun.empleado.serviceempleado.models.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpleadoDto {
    private String idempleado;
    private String nombre;
    private String apellido;
    private String telefono;
    private String dni;
    private String direccion;
    private Date fechaNacimiento;
    private String genero;
    private String cargo;
}
