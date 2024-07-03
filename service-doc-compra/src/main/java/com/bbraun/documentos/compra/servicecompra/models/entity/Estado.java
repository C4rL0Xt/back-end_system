package com.bbraun.documentos.compra.servicecompra.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "estados")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estado {
    @Id
    private Integer idestado;

    @Nationalized
    @Column(name = "estado", length = 30)
    private String estado;

}