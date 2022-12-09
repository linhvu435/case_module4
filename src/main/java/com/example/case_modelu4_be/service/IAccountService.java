package com.example.case_modelu4_be.service;

import com.example.case_modelu4_be.model.Account;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IAccountService extends UserDetailsService {
    List<Account> getAll();
    void save(Account account);
    void delete(Long id);
}
