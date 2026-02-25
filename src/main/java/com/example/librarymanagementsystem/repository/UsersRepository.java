package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsersRepository extends JpaRepository<Users,Integer> {
    Optional<Users>findByUsername(String username);
}
