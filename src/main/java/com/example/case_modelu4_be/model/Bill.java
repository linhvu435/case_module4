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

}
