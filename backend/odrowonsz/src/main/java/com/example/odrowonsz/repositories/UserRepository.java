package com.example.odrowonsz.repositories;

import com.example.odrowonsz.models.database.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> getUserById(Long id);

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserByUsername(String username);

    Optional<Iterable<User>> getUsersByEmailOrUsername(String email, String username);
}
