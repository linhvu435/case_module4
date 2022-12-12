package com.example.case_modelu4_be.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String passWord;
    private String phoneNumber;
    private String email;
    private String address;
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "id_role")
    private Roles role;

    public Account() {
    }

    public Account(long id, String userName, String passWord, String phoneNumber, String email, String address, boolean status, Roles role) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.status = status;
        this.role = role;
    }

    public Account(String userName, String passWord, String phoneNumber, String email, String address, boolean status, Roles role) {
        this.userName = userName;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.status = status;
        this.role = role;
    }
}
