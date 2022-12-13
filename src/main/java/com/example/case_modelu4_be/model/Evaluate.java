package com.example.case_modelu4_be.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Evaluate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int number_star;
    @ManyToOne
    @JoinColumn(name = "id_account")
    private Account account;

    public Evaluate(int number_star) {
        this.number_star = number_star;
    }

    public Evaluate() {

    }
}
