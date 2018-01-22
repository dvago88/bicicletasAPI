package com.danielvargas.controller;

import com.danielvargas.entity.DataEntity;
import com.danielvargas.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DataController {

    @Autowired
    PagingAndSortingRepository pagingAndSortingRepository;

    @Autowired
    DataRepository dataRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<DataEntity> getAllData(Pageable pageable) {
        return (Page<DataEntity>) pagingAndSortingRepository.findAll(pageable);
    }
}
