package com.danielvargas.repository;

import com.danielvargas.entity.DataEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DataRepository extends CrudRepository<DataEntity, Long> {
    List<DataEntity> findByCodigo(String codigo);
}
