package com.danielvargas.controller;

import com.danielvargas.entity.Organizacion;
import com.danielvargas.entity.Suborganizacion;
import com.danielvargas.entity.authentication.Role;
import com.danielvargas.entity.authentication.User;
import com.danielvargas.service.authenticacion.RoleService;
import com.danielvargas.service.authenticacion.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organizacion")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    private int umbralDePoder = 2;


    //    Crear mini admin
    @RequestMapping(
            path = "/crearminiadmin",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> createNewUser(@RequestBody User user) {
//        Si el usuario ya existe o el codigo ya está asignado devolver error
        if (userService.findByUsername(user.getUsername()) != null || userService.findByCodigo(user.getCodigo()) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);//400
        }
        User admin = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Role role = admin.getRole();
        //Este if se podría mezclar con el de abajo, pero es para no hacer tantas llamadas a la DB si no es necesario
        if (role.getId() > umbralDePoder) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//401
        }
        Role newUserRole = roleService.findById(role.getId() + 1);
        Organizacion organizacion = admin.getOrganizacion();
        user.setOrganizacion(organizacion);
//        TODO: mirar que error saca cuando hay algún error en el user para hacer try-catch apropiado
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);//201

//    Eliminar mini admin

//    Actualizar mini admin

//    Ver estadisticas de usos de todos los usuarios de la organización

//    Ver perfil usuarios y/o mini admins

//    Ver datos de cicloparqueaderos

//    Editar su propio perfil

    }

}
