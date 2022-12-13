package com.example.case_modelu4_be.service;

import com.example.case_modelu4_be.model.Account;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IAccountService extends UserDetailsService {
    Account findByUsername(String username);


    Optional<Account> checkDoubleUser(String userName);
}
