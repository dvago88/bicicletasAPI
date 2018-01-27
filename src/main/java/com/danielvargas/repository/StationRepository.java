package com.danielvargas.repository;

import com.danielvargas.entity.Station;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StationRepository extends CrudRepository<Station, Integer> {
    List<Station> findAll();
    Station findById(int id);
}
