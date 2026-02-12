package com.example.librarymanagementsystem.controller;


import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.model.Category;
import com.example.librarymanagementsystem.repository.BookRepository;
import com.example.librarymanagementsystem.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/books")
    public String book(ModelMap modelMap) {
        List<Book> all = bookRepository.findAll();
        modelMap.addAttribute("books", all);
        return "books";
    }

    @GetMapping("/books/delete")
    public String deleteBook(@RequestParam("id") int id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("/addBook")
    public String addBook(ModelMap modelMap) {
        modelMap.addAttribute("categories", categoryRepository.findAll());
        return "addBook";
    }
    @PostMapping("/addBook")
    public String addBook(@RequestParam String title,
                          @RequestParam String author,
                          @RequestParam(required = false) Integer year,
                          @RequestParam String genre,
                          @RequestParam Integer categoryId) {

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setYear(year);
        book.setGenre(genre);

        Category category = categoryRepository.findById(categoryId).orElse(null);
        book.setCategory(category);

        bookRepository.save(book);
        return "redirect:/books";
    }
}