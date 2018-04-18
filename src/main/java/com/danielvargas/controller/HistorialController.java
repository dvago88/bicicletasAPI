package com.danielvargas.controller;

import com.danielvargas.entity.authentication.User;
import com.danielvargas.entity.data.DataEntity;
import com.danielvargas.entity.data.Station;
import com.danielvargas.entity.historial.Historial;
import com.danielvargas.repository.authentication.UserRepository;
import com.danielvargas.repository.data.DataRepository;
import com.danielvargas.repository.data.StationRepository;
import com.danielvargas.repository.historial.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HistorialController {

    @Autowired
    private HistorialRepository historialRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private DataRepository dataRepository;

    @CrossOrigin
    @RequestMapping(path = "/historial/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Historial>> getUserHistorial(@PathVariable long userId) {
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //Si el user autenticado está pidiendo info de otro user negar
        if (authUser.getId() != userId) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//401
        }
        User user = userRepository.findById(userId);
        List<Historial> historial = historialRepository.findByUserOrderByFechaIngresoDesc(user);
        return new ResponseEntity<>(historial, HttpStatus.OK);//200
    }

    @RequestMapping(
            path = "/historial/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Historial> createNewEntryForUser(@RequestBody DataEntity dataEntity) {
        Station station = stationRepository.findById(dataEntity.getStationNumber());
        if (station == null) {
            System.out.println("Estación " + dataEntity.getStationNumber() + " no encontrada");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);//400
        }
        User user = userRepository.findByCodigo(dataEntity.getRfid());
        Historial historial;

        if (station.isAvailable()) {
            if (user == null) {
                System.out.println("Usuario no existe");
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//401
            }
            historial = new Historial(user, station, dataEntity.getTimeInSeconds());
        } else {
            historial = historialRepository.findByStationAndUserOrderByFechaIngresoDesc(station, user).get(0);
            if (historial == null) {
                System.out.println("Aparentemente la estación y el usuario no se encuentran enlazados...");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);//400
            }
            historial.setFechaSalida(dataEntity.getTimeInSeconds());
        }
        historialRepository.save(historial);
        dataRepository.save(dataEntity);
        return new ResponseEntity<>(historial, HttpStatus.CREATED);//201

    }
}
