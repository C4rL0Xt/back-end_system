package com.bbraun.producto.service;

import com.bbraun.producto.models.entity.Lote;
import com.bbraun.producto.models.entity.Producto;

import java.util.List;

public interface ILoteService {

    public List<Lote> findAll();

    public Lote save(Lote lote);
    public List<Lote> saveAll(List<Lote> lotes);

    public List<Lote> findLotesByProductoId(String codigo);

    public List<Lote> findLotesDisponiblesPorProductoId(String id, String estado);

    public String getLastCodeLote();

}
