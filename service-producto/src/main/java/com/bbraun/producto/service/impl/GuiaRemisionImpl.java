package com.bbraun.producto.service.impl;

import com.bbraun.producto.models.entity.GuiaRemision;
import com.bbraun.producto.repository.GuiaRemisionRepository;
import com.bbraun.producto.service.IGuiaRemision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuiaRemisionImpl implements IGuiaRemision{

    @Autowired
    private GuiaRemisionRepository guiaRemisionRepository;
    @Override
    public List<GuiaRemision> findAll() {
        return guiaRemisionRepository.findAll();
    }

    @Override
    public String getLastCode() {
        return guiaRemisionRepository.getLastCode().get(0);
    }

    @Override
    public GuiaRemision save(GuiaRemision guiaRemision) {
        GuiaRemision guiaRemision1 = GuiaRemision.builder()
                .idguiaremision(guiaRemision.getIdguiaremision())
                .idempleado(guiaRemision.getIdempleado())
                .fecha_envio(guiaRemision.getFecha_envio())
                .idpedido(guiaRemision.getIdpedido())
                .build();
        return guiaRemisionRepository.save(guiaRemision1);
    }

    @Override
    public GuiaRemision updateGuia(GuiaRemision guiaRemision) {
        System.out.println(guiaRemision.getIdguiaremision()+" "+guiaRemision.getIdempleado()+" "+guiaRemision.getFecha_envio()+" "+guiaRemision.getIdpedido());

        GuiaRemision guiaRemision1 = guiaRemisionRepository.findById(guiaRemision.getIdguiaremision()).orElse(null);
        GuiaRemision guia = GuiaRemision.builder()
                .idguiaremision(guiaRemision1.getIdguiaremision())
                .idempleado(guiaRemision1.getIdempleado())
                .fecha_envio(guiaRemision.getFecha_envio())
                .idpedido(guiaRemision.getIdpedido())
                .build();

        return guiaRemisionRepository.save(guia);
    }
}
