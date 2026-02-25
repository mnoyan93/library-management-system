package com.example.librarymanagementsystem.controller;


import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.model.Category;
import com.example.librarymanagementsystem.service.BookService;
import com.example.librarymanagementsystem.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
private  final CategoryService categoryService;
    @GetMapping("/books")
    public String book(ModelMap modelMap) {
        List<Book> all = bookService.findAll();
        modelMap.addAttribute("books", all);
        return "books";
    }


    @GetMapping("/books/delete")
    public String deleteBook(@RequestParam("id") int id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("/books/add")
    public String addBook(ModelMap modelMap) {
        modelMap.addAttribute("categories", categoryService.findAll());
        return "addBook";
    }

    @PostMapping("/books/add")
    public String addBook(@ModelAttribute Book book, @RequestParam("categoryId") int categoryId) {

        Category category = categoryService.findById(categoryId);

        book.setCategory(category);

        bookService.save(book);
        return "redirect:/books";
    }
}