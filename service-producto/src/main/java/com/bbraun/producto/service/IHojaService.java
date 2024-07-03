package com.bbraun.producto.service;

import com.bbraun.producto.models.dto.HojaIngresoDto;
import com.bbraun.producto.models.entity.HojaIngreso;

import java.util.List;

public interface IHojaService {

    public List<HojaIngreso> findAll();

    public HojaIngreso findByIdhoja(String idhoja);

    public List<HojaIngresoDto> findAllHojaWithDetails();

    public HojaIngreso saveHojaIngresoWithDetails(HojaIngresoDto dto);

    public List<HojaIngresoDto> findWithDetails();
}
