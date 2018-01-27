package com.danielvargas.controller;

import com.danielvargas.entity.Station;
import com.danielvargas.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StationController {

    @Autowired
    private StationRepository stationRepository;

    @RequestMapping("/stations")
    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    //   Aunque no se envía nada aun es mejor post que get para el futuro que sí se envíe.
    @RequestMapping(value = "/stations/{id}", method = RequestMethod.POST)
    public ResponseEntity<Station> updateStatus(@PathVariable int id) {
        Station station = stationRepository.findById(id);
        station.setAvailable(!station.isAvailable());
        if (station.isAvailable()) {
            station.setNumberOfUses(station.getNumberOfUses() + 1);
        }
        return new ResponseEntity<>(station, HttpStatus.ACCEPTED);
    }

    @RequestMapping("/stations/{id}")
    public ResponseEntity<Station> getOneStation(@PathVariable int id) {
        Station station = stationRepository.findById(id);
        return new ResponseEntity<>(station, HttpStatus.OK);
    }
}
