package com.example.case_modelu4_be.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull

    @Size(min = 6)
    private String userName;
    @NotNull

    @Size(min = 6,max = 8)
    private String passWord;
    @Pattern(regexp = "(09|03|07|08|05)+([0-9]{8})\\b")
    private String phoneNumber;
    @Email
    private String email;
    @Column(columnDefinition = "nvarchar(800)")
    private String address;
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "id_role")
    private Roles roles;

    public Account() {
    }

    public Account(long id, String userName, String passWord, String phoneNumber, String email, String address, boolean status, Roles roles) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.status = status;
        this.roles = roles;
    }
}
