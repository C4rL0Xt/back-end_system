package com.bbraun.documentos.compra.servicecompra.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "ordenes_compra")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdenCompra {
    @Id
    @Column(name = "id_orden_compra")
    private String idordencompra;
    @Column(name = "id_solicitud_cotizacion")
    private String idsolicitudcotizacion;

    @Column(name = "id_proveedor")
    private String idproveedor;
    @Column(name = "fecha_emision")
    private Date fechaemision;

}
