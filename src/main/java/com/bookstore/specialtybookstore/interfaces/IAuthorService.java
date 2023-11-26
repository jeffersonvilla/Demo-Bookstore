package com.bookstore.specialtybookstore.interfaces;

import java.util.List;

import com.bookstore.specialtybookstore.model.Author;

public interface IAuthorService {
    
    // CRUD operations
    public Author createAuthor(Author author);
    
    public Author getAuthorById(int id);
    
    public List<Author> getAllAuthors();
    
    public Author updateAuthor(Author author);
    
    public void deleteAuthor(int id);

    // Search functionality
    public List<Author> searchAuthorByName(String name);
}
