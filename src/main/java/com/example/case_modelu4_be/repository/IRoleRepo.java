package com.example.case_modelu4_be.repository;

import com.example.case_modelu4_be.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IRoleRepo extends JpaRepository<Roles,Long> {
    Roles findByName(String name);

}
