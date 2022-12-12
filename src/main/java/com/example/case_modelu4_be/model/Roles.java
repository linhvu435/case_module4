package com.example.case_modelu4_be.model;

import javax.persistence.*;

import lombok.Data;


@Entity
@Data
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;


    public Roles() {
    }

    public Roles(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Roles(String name) {
        this.name = name;
    }
}
