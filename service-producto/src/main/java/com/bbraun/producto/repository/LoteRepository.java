package com.bbraun.producto.repository;

import com.bbraun.producto.models.entity.Lote;
import com.bbraun.producto.models.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoteRepository extends JpaRepository<Lote,String> {

    List<Lote> findAllByProducto_IdProducto(String codigo);

    List<Lote> findAllByProducto_IdProductoAndAndEstadosDisponibilidad_Estado(String codigo, String estado);

    @Query("SELECT l.idlote from Lote l order by l.idlote desc")
    List<String> getLastCodeLote();

}
