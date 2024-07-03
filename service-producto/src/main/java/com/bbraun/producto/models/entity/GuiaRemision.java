package com.bbraun.producto.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "guias_remision")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuiaRemision {

    @Id
    private String idguiaremision;

    private String idempleado;
    private Date fecha_envio;
    private String idpedido;
}
