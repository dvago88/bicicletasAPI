package com.danielvargas.service.authenticacion;

import com.danielvargas.entity.authentication.Role;
import com.danielvargas.repository.authentication.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findById(int id) {
        return roleRepository.findById(id);
    }
}
