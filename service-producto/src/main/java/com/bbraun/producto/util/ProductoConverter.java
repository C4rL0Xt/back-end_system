package com.bbraun.producto.util;

import com.bbraun.producto.models.dto.ProductoPresentationDto;
import com.bbraun.producto.models.entity.Categoria;
import com.bbraun.producto.models.entity.FormaFarmaceutica;
import com.bbraun.producto.models.entity.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoConverter {

    public Producto convertToEntity(ProductoPresentationDto dto, Categoria categoria, FormaFarmaceutica forma){
        return Producto.builder()
                .idProducto(dto.getCode())
                .idAlmacen("ALM001")
                .idCategoria(categoria)
                .idFormaFarmaceutica(forma)
                .concentracion(dto.getConcentracion())
                .descripcion(dto.getDescription())
                .nombre(dto.getName())
                .precio(dto.getPrice())
                .presentacion(dto.getPresentation())
                .build();
    }
}
