package com.example.case_modelu4_be.model;

import javax.persistence.*;

import lombok.Data;

import java.util.Date;
@Entity
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double totalPrice;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_account")
    private Account account;

    public Bill() {
    }

    public Bill(double totalPrice, Date date, Account account) {
        this.totalPrice = totalPrice;
        this.date = date;
        this.account = account;
    }
}
