package com.bbraun.documentos.compra.servicecompra.repository;

import com.bbraun.documentos.compra.servicecompra.models.dto.SolicitudCompraDto;
import com.bbraun.documentos.compra.servicecompra.models.entity.Estado;
import com.bbraun.documentos.compra.servicecompra.models.entity.SolicitudCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudCompraRepository extends JpaRepository<SolicitudCompra,String> {

    @Query("SELECT s.idsolicitudcompra from SolicitudCompra s order by s.idsolicitudcompra desc")
    List<String> getLastCodeSolicitudCompra();

    @Query(value = "SELECT s.idSolicitudCompra, e.estado, s.idAsistenteCompra, s.nombreProducto, s.cantidad, s.fecha_entrega " +
            "FROM dbo.solicitudes_compra s " +
            "JOIN dbo.estados e on s.idEstado = e.idEstado", nativeQuery = true)
    List<Object[]> findAllWithEstado();

    List<SolicitudCompra> findAllByEstado(Estado estado);



}
