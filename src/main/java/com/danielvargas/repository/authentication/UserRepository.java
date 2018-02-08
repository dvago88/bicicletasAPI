package com.danielvargas.repository.authentication;

import com.danielvargas.entity.authentication.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    User findById(long id);

    User findByCodigo(String codigo);
}
