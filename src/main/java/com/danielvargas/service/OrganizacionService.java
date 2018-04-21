package com.danielvargas.service;

import com.danielvargas.entity.Organizacion;


public interface OrganizacionService {

    void save(Organizacion organizacion);

    void delete(Organizacion organizacion);

    Organizacion findById(int id);

}
