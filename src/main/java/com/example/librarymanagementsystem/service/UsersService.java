package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.Users;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UsersService {

    void save(Users users);

    Optional<Users> findByUsername(String username);
}
