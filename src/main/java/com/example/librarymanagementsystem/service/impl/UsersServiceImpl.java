package com.example.librarymanagementsystem.service.impl;

import com.example.librarymanagementsystem.model.Users;
import com.example.librarymanagementsystem.repository.UsersRepository;
import com.example.librarymanagementsystem.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    //կկանչենք encoder ը
    private final PasswordEncoder passwordEncoder;
    @Override
    public void save(Users users) {
users.setPassword(passwordEncoder.encode(users.getPassword()));
usersRepository.save(users);
//ու այստեղ save կլինի user -ի դրած password -ը db -ում՝ ուրիշ ձևով։
    }

    @Override
    public Optional<Users> findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
}
