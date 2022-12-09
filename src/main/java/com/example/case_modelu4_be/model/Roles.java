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

}
