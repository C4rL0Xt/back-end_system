package com.bbraun.proveedor.repository;

import com.bbraun.proveedor.models.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor,Integer> {

        @Query("select pr from Proveedor pr order by pr.rate desc")
        List<Proveedor> listarPorOrden();

        Proveedor findByIdproveedor(String  idproveedor);

        Proveedor findByEmpresa(String empresa);

}
