package com.example.librarymanagementsystem.service.impl;

import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.repository.BookRepository;

import com.example.librarymanagementsystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Override
  public  List<Book> findAll(){
      return bookRepository.findAll();
  }
  @Override
   public Book save(Book book){
        return bookRepository.save(book);
  }
  @Override
  public  Book findById(Integer id){
        return bookRepository.findById(id).orElse(null);
  }
  @Override
   public void  deleteById(Integer id){
        bookRepository.deleteById(id);
    }
}
