package com.bbraun.documentos.compra.servicecompra.util;

import com.bbraun.documentos.compra.servicecompra.repository.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodigoGeneratorService {

    private static final String PREFIX = "OC-";

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    public String generateCodigo(){
        String ultimoCodigo = ordenCompraRepository.getLastCode().get(0);

        int numeroActual = extraerNumero(ultimoCodigo);
        int siguienteNumero = numeroActual + 1;

        return PREFIX + String.format("%03d", siguienteNumero);
    }

    private int extraerNumero(String codigo){
        return Integer.parseInt(codigo.substring(PREFIX.length()));
    }
}
