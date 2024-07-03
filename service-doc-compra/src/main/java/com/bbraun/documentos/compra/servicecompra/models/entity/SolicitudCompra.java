package com.bbraun.documentos.compra.servicecompra.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "solicitudes_compra")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolicitudCompra {

    @Id
    private String idsolicitudcompra;

    @OneToOne
    @JoinColumn(name = "idestado")
    private Estado estado;

    private String idasistentealmacen;
    private String idasistentecompra;
    private String nombreproducto;
    private Integer cantidad;
    private Date fecha_entrega;
}
