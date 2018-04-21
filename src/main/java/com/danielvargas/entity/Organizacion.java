package com.danielvargas.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Organizacion extends BaseOrg {

    @JsonBackReference
    @OneToMany(mappedBy = "organizacion")
    private List<Suborganizacion> subOrganizaciones = new ArrayList<>();

    public Organizacion() {
        super();
    }

    public List<Suborganizacion> getSubOrganizaciones() {
        return subOrganizaciones;
    }

    public void setSubOrganizaciones(List<Suborganizacion> subOrganizaciones) {
        this.subOrganizaciones = subOrganizaciones;
    }
}
