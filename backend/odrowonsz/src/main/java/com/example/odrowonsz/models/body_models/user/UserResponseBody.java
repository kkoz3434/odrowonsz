package com.example.odrowonsz.models.body_models.user;

import lombok.Data;

@Data
public class UserResponseBody {
    private Long id;

    private String email;

    private String username;

    private String name;

    private String surname;
}