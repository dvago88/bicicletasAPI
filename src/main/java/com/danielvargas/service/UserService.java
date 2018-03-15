package com.danielvargas.service;

import com.danielvargas.entity.authentication.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);

    User findByCodigo(String codigo);
}
