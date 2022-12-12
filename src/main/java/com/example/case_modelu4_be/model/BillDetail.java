package com.example.case_modelu4_be.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int amount;
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "id_bill")
    private Bill bill;

    public BillDetail() {
    }

    public BillDetail( int amount, Product product, Bill bill) {
        this.amount = amount;
        this.product = product;
        this.bill = bill;
    }
}
