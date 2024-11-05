package com.example.odrowonsz.controllers;

import com.example.odrowonsz.models.database.User;
import com.example.odrowonsz.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Returns list of all users"
    )
    @GetMapping("/all")
    public Iterable<User> allUsers() {
        return userService.getAllUsers();
    }

}
