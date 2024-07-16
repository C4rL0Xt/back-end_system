package com.bbraun.empleado.serviceempleado.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transportistas")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transportista {
    @Id
    private String idempleado;
    private String placa;
    private String estado;

}
