package com.danielvargas.service;

import com.danielvargas.entity.Suborganizacion;

public interface SuborganizacionService {

    Suborganizacion findById(int id);

    void save(Suborganizacion suborganizacion);

    void delete(Suborganizacion suborganizacion);
}
