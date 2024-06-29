package com.bbraun.producto.service.impl;

import com.bbraun.producto.repository.FormaFarmaceuticaRepository;
import com.bbraun.producto.models.entity.FormaFarmaceutica;
import com.bbraun.producto.service.IFormaFarmaceuticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormaFarmaceuticaImpl implements IFormaFarmaceuticaService {

    @Autowired
    private FormaFarmaceuticaRepository formaFarmaceuticaDAO;

    @Override
    public List<FormaFarmaceutica> findAll() {
        return (List<FormaFarmaceutica>) formaFarmaceuticaDAO.findAll();
    }

    @Override
    public FormaFarmaceutica findById(String id) {
        return formaFarmaceuticaDAO.findById(id).orElse(null);
    }

    @Override
    public FormaFarmaceutica save(FormaFarmaceutica formaFarmaceutica) {
        return formaFarmaceuticaDAO.save(formaFarmaceutica);
    }

    @Override
    public void deleteById(String id) {
        formaFarmaceuticaDAO.deleteById(id);
    }

    @Override
    public List<String> findFormaName() {
        return formaFarmaceuticaDAO.findAllForms();
    }

    @Override
    public FormaFarmaceutica findByName(String nombre) {
        return formaFarmaceuticaDAO.findFormaByForma(nombre);
    }
}
