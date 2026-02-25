package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {
    List<Book> findAll();

    Book save(Book book);

    Book findById(Integer id);

    void deleteById(Integer id);
}
