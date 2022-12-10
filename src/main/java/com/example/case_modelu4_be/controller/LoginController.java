package com.example.case_modelu4_be.controller;

import com.example.case_modelu4_be.model.Account;
import com.example.case_modelu4_be.model.Roles;
import com.example.case_modelu4_be.service.AccountService;
import com.example.case_modelu4_be.service.IAccountService;
import com.example.case_modelu4_be.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin("*")
//@RequestMapping("/accounts")
public class LoginController {
    @Autowired
    JwtService jwtService;


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AccountService accountService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Account account) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUserName(), account.getPassWord()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtService.generateTokenLogin(authentication);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
    @GetMapping("/register")
    public List<Account> getRegister() {
        return accountService.getAll();
    }

    @PostMapping("/register")
    public Account register(@RequestBody Account account) {
        accountService.save(account);
        accountService.setRoleByID(account.getId());
        return account;
    }
}
