package com.example.odrowonsz.services;

import com.example.odrowonsz.exceptions.EntityNotFound;
import com.example.odrowonsz.mappers.UserMapper;
import com.example.odrowonsz.models.body_models.user.UserRequestBody;
import com.example.odrowonsz.models.body_models.user.UserResponseBody;
import com.example.odrowonsz.models.database.User;
import com.example.odrowonsz.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public Iterable<User> getAllUsers() {
        var usersIterable = userRepository.findAll();
        long size = usersIterable.spliterator().getExactSizeIfKnown();
        return size > 0 ? usersIterable : new ArrayList<>();
    }

    public Boolean checkIfUserExists(String username) {
        var user = userRepository.getUserByUsername(username);
        return user.isPresent();
    }

    public UserResponseBody addUser(UserRequestBody userRequestBody) {
        var doesUsersExist =
                userRepository.getUsersByEmailOrUsername(userRequestBody.getEmail(), userRequestBody.getUsername())
                        .orElseGet(ArrayList::new).spliterator().getExactSizeIfKnown() > 0;
        if (!doesUsersExist) {
            User toAdd = userMapper.fromUserRequestBodyToUser(userRequestBody);
            var saved = userRepository.save(toAdd);
            return userMapper.fromUserToResponseBody(saved);
        }
        else throw new ResponseStatusException(HttpStatus.CONFLICT);
    }

    public UserResponseBody editUser(UserRequestBody userRequestBody, Long userId) {
        var alreadyExistingUser = userRepository.findById(userId);
        if (alreadyExistingUser.isPresent()) {
            User user = userMapper.fromUserRequestBodyToUser(userRequestBody);
            user.setId(userId);
            userRepository.save(user);
            return userMapper.fromUserToResponseBody(user);
        }
        throw new EntityNotFound(User.class);
    }

    public void deleteUser(Long userId) {
        var user = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFound(User.class));
        userRepository.delete(user);
    }
}