package com.danielvargas.repository.historial;

import com.danielvargas.entity.Organizacion;
import com.danielvargas.entity.Suborganizacion;
import com.danielvargas.entity.authentication.User;
import com.danielvargas.entity.data.Station;
import com.danielvargas.entity.historial.Historial;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HistorialRepository extends CrudRepository<Historial, Long> {
    List<Historial> findByUserOrderByFechaIngresoDesc(User user);

    List<Historial> findByStationAndUserOrderByFechaIngresoDesc(Station station, User user);

    List<Historial> findAllBySuborganizacionOrderByFechaIngresoDesc(Suborganizacion suborganizacion);

    List<Historial> findAllByOrganizacionOrderByFechaIngresoDesc(Organizacion organizacion);
}
