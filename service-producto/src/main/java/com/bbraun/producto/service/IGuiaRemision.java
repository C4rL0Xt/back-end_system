package com.bbraun.producto.service;

import com.bbraun.producto.models.entity.GuiaRemision;

import java.util.List;

public interface IGuiaRemision {

    public List<GuiaRemision> findAll();

    public String getLastCode();

    public GuiaRemision save(GuiaRemision guiaRemision);

    public GuiaRemision updateGuia(GuiaRemision guiaRemision);
}
