package com.bbraun.producto.service.impl;

import com.bbraun.producto.models.entity.DetalleHoja;
import com.bbraun.producto.models.entity.HojaIngreso;
import com.bbraun.producto.repository.DetalleHojaRepository;
import com.bbraun.producto.repository.HojaIngresoRepository;
import com.bbraun.producto.service.IDetallHoja;
import com.bbraun.producto.service.IHojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleHojaImpl implements IDetallHoja {

    @Autowired
    private DetalleHojaRepository detalleHojaRepository;

    @Override
    public List<DetalleHoja> findAll() {
        return detalleHojaRepository.findAll();
    }
}
