package com.bbraun.producto.service;

import com.bbraun.producto.models.entity.FormaFarmaceutica;

import java.util.List;

public interface IFormaFarmaceuticaService {

    public List<FormaFarmaceutica> findAll();

    public FormaFarmaceutica findById(String id);

    public FormaFarmaceutica save(FormaFarmaceutica formaFarmaceutica);

    public void deleteById(String id);

    public List<String> findFormaName();

    FormaFarmaceutica findByName(String nombre);
}
