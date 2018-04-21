package com.danielvargas.repository.authentication;

import com.danielvargas.entity.authentication.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findById(int id);
}
