package com.danielvargas.service;

import com.danielvargas.entity.Organizacion;
import com.danielvargas.repository.OrganizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizacionServiceImpl implements OrganizacionService {

    @Autowired
    private OrganizacionRepository organizacionRepository;

    @Override
    public void save(Organizacion organizacion) {
        organizacionRepository.save(organizacion);
    }

    @Override
    public void delete(Organizacion organizacion) {
        organizacionRepository.delete(organizacion);
    }

    @Override
    public Organizacion findById(int id) {
        return organizacionRepository.findById(id);
    }
}
