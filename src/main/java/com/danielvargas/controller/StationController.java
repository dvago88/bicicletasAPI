package com.danielvargas.controller;

import com.danielvargas.entity.data.Station;
import com.danielvargas.repository.data.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {

    @Autowired
    private StationRepository stationRepository;

    @RequestMapping(value = {"/", ""})
    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    //   Aunque no se envía nada aun es mejor post que get para el futuro que sí se envíe.
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity<Station> updateStatus(@PathVariable int id) {
        Station station = stationRepository.findById(id);
        if (station == null) {
            station = new Station(id, false, 0);
            stationRepository.save(station);
            return new ResponseEntity<>(station, HttpStatus.CREATED);//201
        }
        station.setAvailable(!station.isAvailable());
        if (station.isAvailable()) {
            station.setNumberOfUses(station.getNumberOfUses() + 1);
        }
        stationRepository.save(station);
        return new ResponseEntity<>(station, HttpStatus.ACCEPTED);//202
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Station> getOneStation(@PathVariable int id) {
        Station station = stationRepository.findById(id);
        return new ResponseEntity<>(station, HttpStatus.OK);//200
    }
}
