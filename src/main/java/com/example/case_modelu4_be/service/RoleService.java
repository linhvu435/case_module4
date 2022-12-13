package com.example.case_modelu4_be.service;

import com.example.case_modelu4_be.model.Account;
import com.example.case_modelu4_be.model.Roles;
import com.example.case_modelu4_be.repository.IRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService{
    @Autowired
    private IRoleRepo roleRepo;


    public Iterable<Roles> findAll() {
        return roleRepo.findAll();
    }


    public Optional<Roles> findById(Long id) {
        return roleRepo.findById(id);
    }


    public Roles save(Roles roles) {
        return roleRepo.save(roles);
    }


    public void delete(Long id) {
        roleRepo.deleteById(id);
    }

}
