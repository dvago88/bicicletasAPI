package com.danielvargas.repository.historial;

import com.danielvargas.entity.authentication.User;
import com.danielvargas.entity.historial.Historial;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HistorialRepository extends CrudRepository<Historial, Long> {
    List<Historial> findByUserOrderByFechaIngresoDesc(User user);
}
