package com.danielvargas.repository;

import com.danielvargas.entity.Suborganizacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuborganizacionRepository extends CrudRepository<Suborganizacion, Integer> {
    Suborganizacion findById(int id);
}
