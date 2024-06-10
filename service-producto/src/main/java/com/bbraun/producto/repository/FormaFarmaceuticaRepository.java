package com.bbraun.producto.repository;

import com.bbraun.producto.models.entity.FormaFarmaceutica;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaFarmaceuticaRepository extends CrudRepository<FormaFarmaceutica,String> {
}
