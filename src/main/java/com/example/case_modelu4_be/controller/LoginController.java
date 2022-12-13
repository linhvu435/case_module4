package com.example.case_modelu4_be.controller;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/products")
=======
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
>>>>>>> 7c25e567ae131435791e71d22a3086238e2b297c
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
        boolean status = true;
        account.setStatus(status);
        accountService.save(account);
        return new ResponseEntity<>(accountService.save(account), HttpStatus.OK);
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
