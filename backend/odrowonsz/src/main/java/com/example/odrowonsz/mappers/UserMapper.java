package com.example.odrowonsz.mappers;

import com.example.odrowonsz.models.body_models.user.UserRequestBody;
import com.example.odrowonsz.models.body_models.user.UserResponseBody;
import com.example.odrowonsz.models.database.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final PasswordEncoder passwordEncoder;

    public UserResponseBody fromUserToResponseBody(User user) {
        var userResponseBody = new UserResponseBody();
        userResponseBody.setId(user.getId());
        userResponseBody.setEmail(user.getEmail());
        userResponseBody.setUsername(user.getUsername());
        userResponseBody.setName(user.getName());
        userResponseBody.setSurname(user.getSurname());
        return userResponseBody;
    }

    public User fromUserRequestBodyToUser(UserRequestBody userRequestBody) {
        User user = new User();
        user.setEmail(userRequestBody.getEmail());
        user.setName(userRequestBody.getName());
        user.setSurname(userRequestBody.getSurname());
        user.setPassword(passwordEncoder.encode(userRequestBody.getPassword()));
        user.setUsername(userRequestBody.getUsername());
        return user;
    }
}
