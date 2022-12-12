package com.example.case_modelu4_be.repository;

import com.example.case_modelu4_be.model.Account;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.Optional;

public interface IAccountRepo extends CrudRepository<Account , Long> {
    Account findByUserName(String userName);
    Account findByEmail(String email);

    @Query(value = "SELECT * FROM account where user_name = :userName group by user_name;", nativeQuery = true)
    Optional<Account> checkDoubleUser(@Param("userName") String user_name);
}
