package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.Category;

import java.util.List;


public interface CategoryService {
    List<Category> findAll();

    Category save(Category category);

    Category findById(Integer id);

    void deleteById(Integer id);
}
