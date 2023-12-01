package com.bookstore.specialtybookstore.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.specialtybookstore.model.Author;
import com.bookstore.specialtybookstore.service.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private AuthorService authorService;    

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable int id) {
        return authorService.getAuthorById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable int id, @RequestBody Author author) {
        author.setIdAuthor(id);
        return authorService.updateAuthor(author);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable int id) {
        authorService.deleteAuthor(id);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/search")
    public List<Author> searchAuthorByName(@RequestParam String name) {
        return authorService.searchAuthorByName(name);
    }
    
}
