package com.example.case_modelu4_be.model.dto;

import com.example.case_modelu4_be.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserToken {
    private String username;
    private Roles roles;
    private String token;
}
