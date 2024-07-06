package com.bbraun.pedidos.cotizacion.repository;

import com.bbraun.pedidos.cotizacion.models.entity.DetalleCotizacionVenta;
import com.bbraun.pedidos.cotizacion.models.entity.DetalleCotizacionVentaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleCVentaRepository extends JpaRepository<DetalleCotizacionVenta, DetalleCotizacionVentaId> {

    public List<DetalleCotizacionVenta> findAllByIdcotizacion(String idcotizacion);
}
