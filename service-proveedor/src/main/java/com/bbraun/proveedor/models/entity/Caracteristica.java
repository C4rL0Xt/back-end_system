package com.bbraun.proveedor.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "caracteristicas_proveedor")
public class Caracteristica {

    @Id
    @Column(name = "id_caracteristica")
    private Integer idcaracteristica;
    private Integer calidad;
    private Integer precio;
    private Integer cumplimiento;
}
