package com.example.case_modelu4_be.controller;

import com.example.case_modelu4_be.model.Account;
import com.example.case_modelu4_be.model.Roles;
import com.example.case_modelu4_be.service.AccountService;
import com.example.case_modelu4_be.service.IAccountService;
import com.example.case_modelu4_be.service.JwtService;
import com.example.case_modelu4_be.service.RoleService;
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
    @Autowired
    RoleService roleService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Account account) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUserName(), account.getPassWord()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtService.generateTokenLogin(authentication);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody Account account) {
        if (accountService.checkDoubleUser(account.getUserName()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Account account1 = new Account();
        account1.setUserName(account.getUserName());
        account1.setPassWord(account.getPassWord());
        account1.setEmail(account.getEmail());
        account1.setPhoneNumber(account.getPhoneNumber());
        account1.setAddress(account.getAddress());
        String roles = "2";
        Long role1 = Long.parseLong(roles);
        account1.setRoles(roleService.findById(role1).get());
        accountService.save(account1);
        return new ResponseEntity<>(accountService.save(account1), HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<String> admin() {
        return new ResponseEntity<>("Admin", HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<String> user() {
        return new ResponseEntity<>("User", HttpStatus.OK);
    }

    @GetMapping("/register/user")
    public ResponseEntity<Account> checkAccount(@RequestParam String userName) {
        Account account = accountService.findByName(userName);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
    }
    @GetMapping("/register/email")
    public ResponseEntity<Account> checkEmail(@RequestParam String email) {
        Account account = accountService.findByEmail(email);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
    }
}
