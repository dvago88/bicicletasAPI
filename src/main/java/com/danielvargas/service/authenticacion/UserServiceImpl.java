package com.danielvargas.service.authenticacion;

import com.danielvargas.entity.Organizacion;
import com.danielvargas.entity.Suborganizacion;
import com.danielvargas.entity.authentication.User;
import com.danielvargas.repository.authentication.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByCodigo(String codigo) {
        return userRepository.findByCodigo(codigo);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAllBySuborganizacion(Suborganizacion suborganizacion) {
        return userRepository.findAllBySuborganizacion(suborganizacion);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> findAllByOrganizacion(Organizacion organizacion) {
        return userRepository.findAllByOrganizacion(organizacion);
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
