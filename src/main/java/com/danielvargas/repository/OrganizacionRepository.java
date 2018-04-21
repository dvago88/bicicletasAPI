package com.danielvargas.repository;

import com.danielvargas.entity.Organizacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizacionRepository extends CrudRepository<Organizacion, Integer> {
    Organizacion findById(int id);
}
