package com.bbraun.producto.models.service;

import com.bbraun.producto.models.dao.FormaFarmaceuticaDAO;
import com.bbraun.producto.models.entity.FormaFarmaceutica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormaFarmaceuticaImpl implements IFormaFarmaceuticaService{

    @Autowired
    private FormaFarmaceuticaDAO formaFarmaceuticaDAO;

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
}
