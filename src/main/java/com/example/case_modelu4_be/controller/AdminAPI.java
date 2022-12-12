package com.example.case_modelu4_be.controller;

import com.example.case_modelu4_be.model.Account;
import com.example.case_modelu4_be.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminAPI {
    @Autowired
    AdminService adminService;
    @GetMapping("/user")
    public ResponseEntity<List<Account>> findUser(){
        return new ResponseEntity<>(adminService.findUser(), HttpStatus.OK);
    }
    @GetMapping("/shop")
    public ResponseEntity<List<Account>> findShop(){
        return new ResponseEntity<>(adminService.findShop(), HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity deleteAccount(long id){
        adminService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
