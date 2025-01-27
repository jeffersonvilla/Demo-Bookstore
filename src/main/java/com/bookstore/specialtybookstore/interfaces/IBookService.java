package com.bookstore.specialtybookstore.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bookstore.specialtybookstore.DTO.SearchCriteriaDTO;
import com.bookstore.specialtybookstore.model.Book;

public interface IBookService {
    
    // CRUD operations
    public Book createBook(Book book);
    
    public Book getBookById(int id);
    
    public Page<Book> getAllBooks(Pageable pageable);
    
    public Book updateBook(Book book);
    
    public void deleteBook(int id);

    // Search functionality
    public List<Book> searchBookByTitle(String name);

    public List<Book> searchBooksByCriteria(SearchCriteriaDTO criteria);
}
