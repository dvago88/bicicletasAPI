package com.danielvargas.repository.data;

import com.danielvargas.entity.data.Station;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StationRepository extends CrudRepository<Station, Integer> {
    List<Station> findAll();
    Station findById(int id);
}
