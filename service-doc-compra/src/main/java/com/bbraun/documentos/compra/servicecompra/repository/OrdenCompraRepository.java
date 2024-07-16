package com.bbraun.documentos.compra.servicecompra.repository;

import com.bbraun.documentos.compra.servicecompra.models.entity.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompra,String> {

    @Query("SELECT OC.idordencompra from OrdenCompra OC ORDER BY OC.idordencompra DESC")
    List<String> getLastCode();
}
