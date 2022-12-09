package com.example.case_modelu4_be.repository;

import com.example.case_modelu4_be.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface IAccountRepo extends CrudRepository<Account , Long> {
    Account findByUserName(String userName);

}
