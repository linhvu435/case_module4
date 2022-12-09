package com.example.case_modelu4_be.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String img;
    private double price;
    private int amount;
    @ManyToOne
    @JoinColumn(name = "id_shop")
    private Shop shop;
}
