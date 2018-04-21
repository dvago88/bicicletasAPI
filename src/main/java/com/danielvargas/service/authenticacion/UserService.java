package com.danielvargas.service.authenticacion;

import com.danielvargas.entity.Organizacion;
import com.danielvargas.entity.Suborganizacion;
import com.danielvargas.entity.authentication.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);

    User findByCodigo(String codigo);

    User findById(long id);

    List<User> findAllBySuborganizacion(Suborganizacion suborganizacion);

    List<User> findAllByOrganizacion(Organizacion organizacion);

    void save(User user);

    void delete(User user);
}
