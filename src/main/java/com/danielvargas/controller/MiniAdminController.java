package com.danielvargas.controller;

import com.danielvargas.entity.Organizacion;
import com.danielvargas.entity.Suborganizacion;
import com.danielvargas.entity.authentication.Role;
import com.danielvargas.entity.authentication.User;
import com.danielvargas.entity.historial.Historial;
import com.danielvargas.repository.SuborganizacionRepository;
import com.danielvargas.service.SuborganizacionService;
import com.danielvargas.service.authenticacion.RoleService;
import com.danielvargas.service.historial.HistorialService;
import com.danielvargas.service.authenticacion.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: Hay mucho codigo repetido en estos metodos, mirar como refactorizar para evitar repetir tanto
@RestController
@RequestMapping("/organizacion/suborganizacion")
public class MiniAdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private SuborganizacionService suborganizacionService;

    @Autowired
    private HistorialService historialService;

    @Autowired
    private RoleService roleService;

    private int umbralDePoder = 3;


    //    Crear usuario
    @RequestMapping(
            path = "/crearusuario",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> createNewUser(@RequestBody User user) {
//        Si el usuario ya existe o el codigo ya está asignado devolver error
        if (userService.findByUsername(user.getUsername()) != null || userService.findByCodigo(user.getCodigo()) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);//400
        }
        User miniAdmin = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Role role = miniAdmin.getRole();
        //Este if se podría mezclar con el de abajo, pero es para no hacer tantas llamadas a la DB si no es necesario
        if (role.getId() > umbralDePoder) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//401
        }
        Suborganizacion suborganizacion;
        Organizacion organizacion = miniAdmin.getOrganizacion();
//        Si el que crea usuario es superadmin
        if (role.getId() > umbralDePoder - 1) {
            suborganizacion = miniAdmin.getSuborganizacion();
            user.setSuborganizacion(suborganizacion);
        }
        user.setOrganizacion(organizacion);
        user.setRole(roleService.findById(role.getId() + 1)); //Quede en rol Usuario
//        TODO: mirar que error saca cuando hay algún error en el user para hacer try-catch apropiado
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);//201
    }

    //    Actualizar datos de usuario
    @RequestMapping(
            path = "/actualizarusuario",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User miniAdmin = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Role role = miniAdmin.getRole();
        //Este if se podría mezclar con el de abajo, pero es para no hacer tantas llamadas a la DB si no es necesario
        if (role.getId() > umbralDePoder) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//401
        }
        Suborganizacion suborganizacion = user.getSuborganizacion();//Por si es un super admin el que agrega
        Organizacion organizacion = miniAdmin.getOrganizacion();
        if (role.getId() > umbralDePoder - 1) {
            suborganizacion = miniAdmin.getSuborganizacion();
        }
//        Si el usuario no pertenece a la organización y suborganización del mini admin rechazar
        if (suborganizacion != user.getSuborganizacion() || organizacion != user.getOrganizacion()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//401
        }
        user.setRole(roleService.findById(role.getId() + 1)); //Quede en rol Usuario
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);//200
    }

    //    Eliminar usuario
    @RequestMapping(
            path = "/eliminarusuario",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> deleteUser(@RequestBody User user) {
        User miniAdmin = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Role role = miniAdmin.getRole();
        //Este if se podría mezclar con el de abajo, pero es para no hacer tantas llamadas a la DB si no es necesario
        if (role.getId() > umbralDePoder) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//401
        }
        Suborganizacion suborganizacion = user.getSuborganizacion();//Por si es un super admin el que agrega
        Organizacion organizacion = miniAdmin.getOrganizacion();
        if (role.getId() > umbralDePoder - 1) {
            suborganizacion = miniAdmin.getSuborganizacion();
        }
//        Si el usuario no pertenece a la organización y suborganización del mini admin rechazar
        if (suborganizacion != user.getSuborganizacion() || organizacion != user.getOrganizacion()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//401
        }
        userService.delete(user);
        return new ResponseEntity<>(HttpStatus.OK);//200
    }

//    Ver usuarios

    @RequestMapping(
            path = "/{suborganizacionId}/getallusers",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<List<User>> getUsers(@PathVariable int suborganizacionId) {
        Suborganizacion suborganizacionSolicitada = getSuborganizacion(suborganizacionId);
        if (suborganizacionSolicitada == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//401
        }
        List<User> allUsers = userService.findAllBySuborganizacion(suborganizacionSolicitada);
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    //    Ver historial de sus usuarios
    @RequestMapping(
            path = "/{suborganizacionId}/getallhistory",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<List<Historial>> getAllUsersHistory(@PathVariable int suborganizacionId) {
        Suborganizacion suborganizacionSolicitada = getSuborganizacion(suborganizacionId);
        if (suborganizacionSolicitada == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//401
        }
        List<Historial> allHistory = historialService.findAllBySuborganizacionOrderByFechaIngresoDesc(suborganizacionSolicitada);
        return new ResponseEntity<>(allHistory, HttpStatus.OK);
    }

    private Suborganizacion getSuborganizacion(int suborganizacionId) {
        User miniAdmin = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Role role = miniAdmin.getRole();
        //Si el rol no es super admin, admin o mini admin rechazar
        //Este if se podría mezclar con el de abajo, pero es para no hacer tantas llamadas a la DB si no es necesario
        if (role.getId() > umbralDePoder) {
            return null;
        }
        Suborganizacion suborganizacion = miniAdmin.getSuborganizacion();
        if (role.getId() > umbralDePoder - 1 && suborganizacionId != suborganizacion.getId()) {
            return null;
        }
        return suborganizacionService.findById(suborganizacionId);
    }

//    Ver perfil usuario

//    Editar su propio perfil
}
