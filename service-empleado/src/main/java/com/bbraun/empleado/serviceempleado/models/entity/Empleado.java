package com.bbraun.empleado.serviceempleado.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "empleados")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empleado {
    @Id
    private String idempleado;

    @OneToOne
    @JoinColumn(name = "idcuenta")
    private Usuario cuenta;

    private String nombre;
    private String apellido;
    private String telefono;
    private String dni;
    private String direccion;
    private Date fechanacimiento;
    private String genero;
    private String cargo;
}
