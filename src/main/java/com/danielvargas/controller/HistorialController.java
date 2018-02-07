package com.danielvargas.controller;

import com.danielvargas.entity.Tiempo;
import com.danielvargas.entity.authentication.User;
import com.danielvargas.entity.data.Station;
import com.danielvargas.entity.historial.Historial;
import com.danielvargas.repository.authentication.UserRepository;
import com.danielvargas.repository.data.StationRepository;
import com.danielvargas.repository.historial.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class HistorialController {

    @Autowired
    private HistorialRepository historialRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StationRepository stationRepository;

    @RequestMapping(path = "/historial/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Historial>> getUserHistorial(@PathVariable long userId) {
        User user = userRepository.findById(userId);
        List<Historial> historial = historialRepository.findByUserOrderByFechaIngresoDesc(user);
        return new ResponseEntity<>(historial, HttpStatus.OK);//200
    }

    //    TODO: Encontrar una mejor manera de obtener el código de usuario
//    Me imagino que haciendo un get al usuario des
    @RequestMapping(
            path = "/historial/{stationNumber}/{userCode}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Historial> createNewEntryForUser(@PathVariable String userCode, @PathVariable int stationNumber, @RequestBody Tiempo fechaIngreso) {
        Station station = stationRepository.findById(stationNumber);
        if (station == null) {
            System.out.println("No se ha creado la malparida estacion antes");
        }
        User user = userRepository.findByCodigo(userCode);
        if (user == null) {
            System.out.println("Usuario no existe");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//401
        }
        Historial historial = new Historial(user, station, fechaIngreso.getLocalDateTime());
        historialRepository.save(historial);
        return new ResponseEntity<>(historial, HttpStatus.CREATED);//201

    }
}
