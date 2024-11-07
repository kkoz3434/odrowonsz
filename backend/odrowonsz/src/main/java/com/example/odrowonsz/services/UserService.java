package com.example.odrowonsz.services;

import com.example.odrowonsz.models.database.User;
import com.example.odrowonsz.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {
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
}