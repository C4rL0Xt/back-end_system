package com.bbraun.producto.util;

import com.bbraun.producto.models.dto.HojaIngresoDto;
import com.bbraun.producto.models.entity.DetalleHoja;
import com.bbraun.producto.models.entity.HojaIngreso;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DetalleHojaConverter {

    public HojaIngreso convertToEntity(HojaIngresoDto dto) {
        HojaIngreso hojaIngreso = HojaIngreso.builder()
                .idhoja(dto.getIdhoja())
                .idempleado(dto.getIdempleado())
                .fechaingreso(dto.getFechaingreso())
                .build();
        return hojaIngreso;
    }

    public DetalleHoja convertToEntityDetails(HojaIngresoDto dto) {
        DetalleHoja detalleHoja = DetalleHoja.builder()
                .idhoja(dto.getIdhoja())
                .idproducto(dto.getDetalles().get(0).getIdproducto())
                .cantidad(dto.getDetalles().get(0).getCantidad())
                .build();
        return detalleHoja;
    }
}
