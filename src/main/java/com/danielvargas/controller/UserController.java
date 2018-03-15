package com.danielvargas.controller;

import com.danielvargas.entity.authentication.User;
import com.danielvargas.entity.historial.Historial;
import com.danielvargas.repository.historial.HistorialRepository;
import com.danielvargas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HistorialRepository historialRepository;


    @RequestMapping("/user/code/{userCode}")
    public ResponseEntity<Long> getUserByCode(@PathVariable String userCode) {
        User user = userService.findByCodigo(userCode);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//401
        }
        return new ResponseEntity<>(user.getId(), HttpStatus.OK);//200
    }

    //Metodo repetido en HistorialController, OJO
    @RequestMapping("/user/{username}")
    public ResponseEntity<List<Historial>> getUserByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        if (user == null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//401

        List<Historial> historial = historialRepository.findByUserOrderByFechaIngresoDesc(user);

        return new ResponseEntity<>(historial, HttpStatus.OK);//200
    }
}
