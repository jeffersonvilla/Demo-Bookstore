package com.bookstore.specialtybookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.specialtybookstore.interfaces.IBookService;
import com.bookstore.specialtybookstore.model.Book;
import com.bookstore.specialtybookstore.repository.BookRepository;

@Service
public class BookService implements IBookService{
    
    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book createBook(Book book) {
        return this.repository.save(book);
    }

    @Override
    public Book getBookById(int id) {
        return this.repository.findById(id).get();
    }

    @Override
    public List<Book> getAllBooks() {
        return this.repository.findAll();
    }

    @Override
    public Book updateBook(Book book) {
        return this.repository.save(book);
    }

    @Override
    public void deleteBook(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<Book> searchBookByTitle(String name) {
        return this.repository.searchBookByTitleLike(name);
    }
    
}
