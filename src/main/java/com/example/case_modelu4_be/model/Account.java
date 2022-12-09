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

}
