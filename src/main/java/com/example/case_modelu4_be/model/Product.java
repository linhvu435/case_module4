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

    public Product() {
    }

    public Product(long id, String name, String img, double price, int amount, Shop shop) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.amount = amount;
        this.shop = shop;
    }
}
