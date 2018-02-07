package com.danielvargas.controller;

import com.danielvargas.entity.authentication.User;
import com.danielvargas.repository.authentication.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/user/{userCode}")
    public ResponseEntity<Long> getUser(@PathVariable String userCode) {
        User user = userRepository.findByCodigo(userCode);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//401
        }
        return new ResponseEntity<>(user.getId(), HttpStatus.OK);//200
    }
}
