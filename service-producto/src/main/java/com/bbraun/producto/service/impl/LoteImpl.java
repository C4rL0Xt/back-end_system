package com.bbraun.producto.service.impl;

import com.bbraun.producto.models.entity.Lote;
import com.bbraun.producto.models.entity.Producto;
import com.bbraun.producto.repository.LoteRepository;
import com.bbraun.producto.service.ILoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoteImpl implements ILoteService {

    @Autowired
    private LoteRepository loteRepository;

    @Override
    public Lote save(Lote lote) {

        return loteRepository.save(lote);
    }

    @Override
    public List<Lote> saveAll(List<Lote> lotes) {
        return loteRepository.saveAll(lotes);
    }

    @Override
    public List<Lote> findAll() {
        return loteRepository.findAll();
    }

    @Override
    public List<Lote> findLotesByProductoId(String codigo) {
        return loteRepository.findAllByProducto_IdProducto(codigo);
    }

    @Override
    public List<Lote> findLotesDisponiblesPorProductoId(String id, String estado) {
        return loteRepository.findAllByProducto_IdProductoAndAndEstadosDisponibilidad_Estado(id,estado);
    }

    @Override
    public String getLastCodeLote() {
        return loteRepository.getLastCodeLote().get(0);
    }
}
