package com.example.odrowonsz.services;

import com.example.odrowonsz.models.database.User;
import com.example.odrowonsz.repositiories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Iterable<User> getAllUsers() {
       var usersIterable = userRepository.findAll();
       long size = usersIterable.spliterator().getExactSizeIfKnown();
       return size > 0 ? usersIterable : new ArrayList<>();
    }
}