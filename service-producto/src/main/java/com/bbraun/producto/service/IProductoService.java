package com.bbraun.producto.service;

import com.bbraun.producto.models.dto.ProductoDTO;
import com.bbraun.producto.models.dto.ProductoPresentationDto;
import com.bbraun.producto.models.entity.Categoria;
import com.bbraun.producto.models.entity.Lote;
import com.bbraun.producto.models.entity.Producto;
import com.bbraun.producto.models.proyeccion.ProductoProjection;

import java.util.List;

public interface IProductoService {

    public List<Producto> findAll();

    public Producto findById(String id);

    public Producto save(Producto producto);

    public void deleteById(String id);

    public ProductoPresentationDto findByNombreAndAndConcentracion(String nombre, String concentracion);

    List<Producto> findByIdCategoria(Categoria categoria);

    List<Producto> findByNombre(String nombre);

    ProductoDTO findLotesDisponibles(String id);

    public List<ProductoPresentationDto> findAllWithLots();

    public String getLastCodeProducto();

    public Producto createProductoWithLots(ProductoPresentationDto dto);

    public Producto updateProductoWithLots( ProductoPresentationDto dto);

    public ProductoPresentationDto findProductoWithLots(String id);


}
