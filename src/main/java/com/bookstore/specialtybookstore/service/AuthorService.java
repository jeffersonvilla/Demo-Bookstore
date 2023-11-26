package com.bookstore.specialtybookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.specialtybookstore.interfaces.IAuthorService;
import com.bookstore.specialtybookstore.model.Author;
import com.bookstore.specialtybookstore.repository.AuthorRepository;

@Service
public class AuthorService implements IAuthorService{

    private AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Author createAuthor(Author author) {
        return this.repository.save(author);
    }

    @Override
    public Author getAuthorById(int id) {
        return this.repository.findById(id).get();
    }

    @Override
    public List<Author> getAllAuthors() {
        return this.repository.findAll();
    }

    @Override
    public Author updateAuthor(Author author) {
        return this.repository.save(author);
    }

    @Override
    public void deleteAuthor(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<Author> searchAuthorByName(String name) {
        return this.repository.searchAuthorByNameLike(name);
    }
    
}
