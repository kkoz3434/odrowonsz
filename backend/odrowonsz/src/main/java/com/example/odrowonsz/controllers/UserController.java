package com.example.odrowonsz.controllers;

import com.example.odrowonsz.models.body_models.user.UserRequestBody;
import com.example.odrowonsz.models.body_models.user.UserResponseBody;
import com.example.odrowonsz.models.database.User;
import com.example.odrowonsz.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Returns list of all users")
    @GetMapping("/all")
    public ResponseEntity<Iterable<User>> allUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{username}")
    @Operation(summary = "Returns true if given username exists in database")
    public ResponseEntity<Boolean> doesUserExist(@PathVariable String username) {
        return ResponseEntity.ok(userService.checkIfUserExists(username));
    }

    @PostMapping()
    @Operation(summary = "Adding user, returns user added to database")
    public ResponseEntity<UserResponseBody> addUser(@RequestBody UserRequestBody userRequestBody) {
        return ResponseEntity.ok(userService.addUser(userRequestBody));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit already existing user")
    public ResponseEntity<UserResponseBody> editUser(@PathVariable Long id, @RequestBody UserRequestBody userRequestBody) {
        return ResponseEntity.ok(userService.editUser(userRequestBody, id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete existing user")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
