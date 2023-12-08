package com.bookstore.specialtybookstore.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.specialtybookstore.DTO.SearchCriteriaDTO;
import com.bookstore.specialtybookstore.interfaces.IBookService;
import com.bookstore.specialtybookstore.model.Book;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private IBookService bookService;    

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        book.setIdBook(id);
        return bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/search")
    public List<Book> searchBookByTitle(@RequestParam String title) {
        return bookService.searchBookByTitle(title);
    }

    @GetMapping("/search/criteria")
    public List<Book> searchBooksByCriteria(
        @RequestParam(name = "title", required = false) String title,
        @RequestParam(name = "genre", required = false) List<String> genreNames,
        @RequestParam(name = "author", required = false) List<String> authorNames,
        @RequestParam(name = "publisher", required = false) List<String> publisherNames
    ){
        SearchCriteriaDTO criteria = new SearchCriteriaDTO();

        criteria.setTitle(title);
        criteria.setGenreNames(genreNames);
        criteria.setAuthorNames(authorNames);
        criteria.setPublisherNames(publisherNames);

        return bookService.searchBooksByCriteria(criteria);
    }
    
}
