package com.example.case_modelu4_be.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text;
    @ManyToOne
    @JoinColumn(name = "id_account")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    public Comment() {
    }
}
