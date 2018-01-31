package com.danielvargas.controller;

import com.danielvargas.entity.DataEntity;
import com.danielvargas.repository.DataRepository;
import com.danielvargas.repository.PageableRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class DataController {

    @Autowired
    PageableRepository pageableRepository;

    @Autowired
    DataRepository dataRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<DataEntity> getAllData(Pageable pageable) {
        return pageableRepository.findAll(pageable);
    }


    @RequestMapping(path = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<DataEntity> crearData(@RequestBody DataEntity dataEntity) {
        if (dataEntity.getLocalDateTime() == null) {
            dataEntity.setLocalDateTime(LocalDateTime.now());
        }
        dataRepository.save(dataEntity);

        return new ResponseEntity<>(dataEntity, HttpStatus.CREATED);
    }

    @RequestMapping("/{station}")
    public ResponseEntity<DataEntity> getOneData(@PathVariable int station) {
        DataEntity dataEntity = dataRepository.findByStationNumberOrderByLocalDateTimeDesc(station).get(0);
//        TODO: Hacer algo si no se encuentran datos
        return new ResponseEntity<>(dataEntity, HttpStatus.OK);
    }
}
