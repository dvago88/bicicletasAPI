package com.danielvargas.service;

import com.danielvargas.entity.authentication.User;
import com.danielvargas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        TODO: Hacer algo si no se encuentra el usuario
        User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException("Usuario no encontrado");
        return user;
//        Si User no implementa userdetails se devuelve como abajo:
//        return new org.springframework.security.core.userdetails.User(
//                user.getUsername()
//                , user.getPassword()
//                , user.getAuthorities());
    }
}
