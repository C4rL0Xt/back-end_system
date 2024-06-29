package com.bbraun.producto.repository;

import com.bbraun.producto.models.entity.FormaFarmaceutica;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormaFarmaceuticaRepository extends CrudRepository<FormaFarmaceutica,String> {

    @Query("SELECT f.forma FROM FormaFarmaceutica f")
    List<String> findAllForms();

    FormaFarmaceutica findFormaByForma(String forma);
}
