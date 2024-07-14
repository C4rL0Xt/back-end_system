package com.bbraun.pedidos.cotizacion.util;

import com.bbraun.pedidos.cotizacion.models.Producto;
import com.bbraun.pedidos.cotizacion.models.dto.CotizacionDtoPDF;
import com.bbraun.pedidos.cotizacion.models.dto.DetalleDtoPDF;
import com.bbraun.pedidos.cotizacion.models.entity.CotizacionVenta;
import com.bbraun.pedidos.cotizacion.models.entity.DetalleCotizacionVenta;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConverterToDto {

    public CotizacionDtoPDF convertCotizacionEntityToDto(CotizacionVenta cotizacionVenta, List<DetalleDtoPDF> detalles){
        CotizacionDtoPDF cotizacionDto = CotizacionDtoPDF.builder()
                .idcotizacion(cotizacionVenta.getId_cotizacion())
                .estado(cotizacionVenta.getEstado().getEstado())
                .cliente(cotizacionVenta.getNombre_cliente())
                .monto_producto(cotizacionVenta.getMonto_producto())
                .fecha_emision(cotizacionVenta.getFecha_emision())
                .email(cotizacionVenta.getEmail())
                .monto_impuesto(cotizacionVenta.getMonto_impuesto())
                .monto_total(cotizacionVenta.getMonto_total())
                .departamento(cotizacionVenta.getId_departamento().getNombreDepartamento())
                .detalles(detalles)
                .build();
        return cotizacionDto;
    }

    public DetalleDtoPDF converterDetallVToDto(DetalleCotizacionVenta detalleCotizacionVenta, Producto producto){
        DetalleDtoPDF detalleDto = DetalleDtoPDF.builder()
                .producto(producto)
                .cantidad(detalleCotizacionVenta.getCantidad())
                .build();
        return detalleDto;
    }


}
