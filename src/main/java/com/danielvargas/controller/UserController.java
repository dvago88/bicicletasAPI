package com.danielvargas.controller;

import com.danielvargas.entity.authentication.User;
import com.danielvargas.entity.historial.Historial;
import com.danielvargas.repository.historial.HistorialRepository;
import com.danielvargas.service.authenticacion.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase controladora que se encarga de la autenticacion de los usuarios
 *
 * @author Daniel Vargas
 * @since 2018-04-01
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * Campo de usuario de servicio
     */
    @Autowired
    private UserService userService;

    /**
     * Campo del historial
     */
    @Autowired
    private HistorialRepository historialRepository;

    /**
     * Al pasarle el código del usuario este metodo lo obtiene y lo devuelve.
     *
     * @param userCode código del usuario.
     * @return ResposeEntity con el usuario (si el login es correcto) y el status http correcto.
     */
    @RequestMapping("/code/{userCode}")
    public ResponseEntity<User> getUserByCode(@PathVariable String userCode) {
        User user = userService.findByCodigo(userCode);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);//400
        }
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (dontHavePermission(user, authUser)) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//401
//        TODO: Arreglar el codigo de python...
        return new ResponseEntity<>(user, HttpStatus.OK);//200
    }

    /**
     * Al pasarle el nombre de usuario obtiene el historial del mismo y lo devuelve.
     *
     * @param username nombre de usuario.
     * @return ResposeEntity con el usuario (si el login es correcto) y el status http correcto.
     */
    @RequestMapping(path = "/username/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> getUserHistorial(@PathVariable String username) {
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //Si el user autenticado está pidiendo info de otro user negar
        if (!authUser.getUsername().equals(username) && authUser.getRole().getId() > 4) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//401
        }
        User user = userService.findByUsername(username);

        if (authUser.getRole().getId() == 3 && !authUser.getSuborganizacion().getId().equals(user.getSuborganizacion().getId())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//401
        }
        return new ResponseEntity<>(user, HttpStatus.OK);//200
    }

    //TODO: Refactorizar este método pues está repetido en el historial también

    /**
     * Al pasarle el username del usuario este metodo lo ootiene y lo devuelve.
     *
     * @param username nombre de usuario.
     * @return ResposeEntity con el usuario (si el login es correcto) y el status http correcto.
     */
    @RequestMapping("/{username}")
    public ResponseEntity<List<Historial>> getUserByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        if (user == null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//401
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //Si el user autenticado está pidiendo info de otro user negar
        if (dontHavePermission(user, authUser)) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//401
        List<Historial> historial = historialRepository.findByUserOrderByFechaIngresoDesc(user);
        return new ResponseEntity<>(historial, HttpStatus.OK);//200
    }

    /**
     * Actualiza el usuario.
     *
     * @param user objeto usuario a actualizar.
     * @return ResposeEntity con el usuario actualizado(si el login es correcto) y el status http correcto.
     */
    @RequestMapping(path = "/updateprofile",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> updateUserProfile(@RequestBody User user) {
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (dontHavePermission(user, authUser)) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//401
        user.setOrganizacion(authUser.getOrganizacion());
        if (authUser.getRole().getId() > 2) {
            user.setSuborganizacion(authUser.getSuborganizacion());
        }
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Método auxiliar que determina si un usuario tiene los permisos necesarios en la aplicación.
     *
     * @param user     objeto con el usuario a revisar.
     * @param authUser objeto con el usuario autenticado.
     * @return booleano true si el usuario tiene permiso.
     */
    private boolean dontHavePermission(User user, User authUser) {
        boolean isTheCorrectRole = authUser.getRole().getId() > 4;
        boolean isTheCorrectUser = authUser.getId() != user.getId();
        boolean isTrue = isTheCorrectRole && isTheCorrectUser;
//        return authUser.getRole().getId() > 4 && authUser.getId() != user.getId();
        return isTrue;
    }
}
