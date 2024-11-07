package com.example.odrowonsz.controllers;

import com.example.odrowonsz.models.database.User;
import com.example.odrowonsz.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Returns list of all users")
    @GetMapping("/all")
    public ResponseEntity<Iterable<User>> allUsers() {
        var result = userService.getAllUsers();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    @Operation(summary = "Returns true if given username exists in database")
    public ResponseEntity<Boolean> doesUserExist(@PathVariable String username) {
        var result = userService.checkIfUserExists(username);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
