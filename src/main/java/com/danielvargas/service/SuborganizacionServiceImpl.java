package com.danielvargas.service;

import com.danielvargas.entity.Suborganizacion;
import com.danielvargas.repository.SuborganizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuborganizacionServiceImpl implements SuborganizacionService {

    @Autowired
    private SuborganizacionRepository suborganizacionRepository;

    @Override
    public Suborganizacion findById(int id) {
        return suborganizacionRepository.findById(id);
    }

    @Override
    public void save(Suborganizacion suborganizacion) {
        suborganizacionRepository.save(suborganizacion);
    }

    @Override
    public void delete(Suborganizacion suborganizacion) {
        suborganizacionRepository.delete(suborganizacion);
    }
}
