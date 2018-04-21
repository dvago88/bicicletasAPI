package com.danielvargas.entity.historial;

import com.danielvargas.entity.Organizacion;
import com.danielvargas.entity.Suborganizacion;
import com.danielvargas.entity.authentication.User;
import com.danielvargas.entity.data.Station;

import javax.persistence.*;

@Entity
public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @JoinColumn(name = "station_id")
    @ManyToOne
    private Station station;

    @OneToOne
    @JoinColumn(name = "organizacion_id")
    private Organizacion organizacion;

    @OneToOne
    @JoinColumn(name = "suborganizacion_id")
    private Suborganizacion suborganizacion;

    private Long fechaSalida;
    private Long fechaIngreso;


    public Historial() {
    }

    public Historial(User user, Station station, Organizacion organizacion, Suborganizacion suborganizacion, Long fechaIngreso) {
        this.user = user;
        this.station = station;
        this.fechaIngreso = fechaIngreso;
        this.organizacion = organizacion;
        this.suborganizacion = suborganizacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Long getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Long fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public Suborganizacion getSuborganizacion() {
        return suborganizacion;
    }

    public void setSuborganizacion(Suborganizacion suborganizacion) {
        this.suborganizacion = suborganizacion;
    }

    public Long getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Long fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
