package com.danielvargas.service.historial;

import com.danielvargas.entity.Organizacion;
import com.danielvargas.entity.Suborganizacion;
import com.danielvargas.entity.authentication.User;
import com.danielvargas.entity.data.Station;
import com.danielvargas.entity.historial.Historial;
import com.danielvargas.repository.historial.HistorialRepository;
import com.danielvargas.service.historial.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialServiceImpl implements HistorialService {

    @Autowired
    HistorialRepository historialRepository;

    @Override
    public List<Historial> findByUserOrderByFechaIngresoDesc(User user) {
        return historialRepository.findByUserOrderByFechaIngresoDesc(user);
    }

    @Override
    public List<Historial> findByStationAndUserOrderByFechaIngresoDesc(Station station, User user) {
        return historialRepository.findByStationAndUserOrderByFechaIngresoDesc(station, user);
    }

    @Override
    public List<Historial> findAllBySuborganizacionOrderByFechaIngresoDesc(Suborganizacion suborganizacion) {
        return historialRepository.findAllBySuborganizacionOrderByFechaIngresoDesc(suborganizacion);
    }

    @Override
    public List<Historial> findAllByOrganizacionOrderByFechaIngresoDesc(Organizacion organizacion) {
        return historialRepository.findAllByOrganizacionOrderByFechaIngresoDesc(organizacion);
    }

    @Override
    public void save(Historial historial) {
        historialRepository.save(historial);
    }
}
