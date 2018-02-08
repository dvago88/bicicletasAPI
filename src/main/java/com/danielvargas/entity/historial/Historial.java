package com.danielvargas.entity.historial;

import com.danielvargas.entity.authentication.User;
import com.danielvargas.entity.data.Station;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    private LocalDateTime fechaSalida;
    private LocalDateTime fechaIngreso;

    public Historial() {
    }

    public Historial(User user, Station station, LocalDateTime fechaIngreso) {
        this.user = user;
        this.station = station;
        this.fechaSalida = fechaSalida;
        this.fechaIngreso = fechaIngreso;
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

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}