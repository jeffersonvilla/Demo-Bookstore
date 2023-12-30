package com.bookstore.specialtybookstore.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.bookstore.specialtybookstore.DTO.BookDTO;
import com.bookstore.specialtybookstore.DTO.SearchCriteriaDTO;
import com.bookstore.specialtybookstore.interfaces.IBookService;
import com.bookstore.specialtybookstore.mapper.BookMapper;
import com.bookstore.specialtybookstore.model.Book;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/book")
@Tag(name = "Book Controller", description = "Operations related to books")
@CrossOrigin(origins = "http://localhost:3000/")
public class BookController {

    private IBookService bookService;
    private BookMapper mapper;    

    public BookController(IBookService bookService, BookMapper mapper) {
        this.bookService = bookService;
        this.mapper = mapper;
    }

    @PostMapping
    @Operation(summary = "Create a new book", responses = {
        @ApiResponse(responseCode = "201", description = "Book created", content = {
             @Content(mediaType = "application/json", schema = @Schema(implementation = BookDTO.class))
        }),
        @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO bookDTO) {
        
        Book createdBook = bookService.createBook(mapper.toBook(bookDTO));

        return new ResponseEntity<BookDTO>(mapper.toDTO(createdBook), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all books", responses = {
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    public ResponseEntity<List<BookDTO>> getAllBooks( 
            @Parameter(description = "Page number", in = ParameterIn.QUERY) 
                @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Number of items per page", in = ParameterIn.QUERY)    
                @RequestParam(defaultValue = "10") int size ) {

        PageRequest pageable = PageRequest.of(page, size);

        Page<Book> bookPage = bookService.getAllBooks(pageable);
        List<BookDTO> books = bookPage.getContent().stream().map(mapper::toDTO).toList();

        return new ResponseEntity<List<BookDTO>>(books, HttpStatus.OK);
    }
/* 
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
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
        @RequestParam(name = "description", required = false) String descriptionText,
        @RequestParam(name = "genre", required = false) List<String> genreNames,
        @RequestParam(name = "author", required = false) List<String> authorNames,
        @RequestParam(name = "publisher", required = false) List<String> publisherNames
    ){
        SearchCriteriaDTO criteria = new SearchCriteriaDTO();

        criteria.setTitle(title);
        criteria.setDescriptionText(descriptionText);
        criteria.setGenreNames(genreNames);
        criteria.setAuthorNames(authorNames);
        criteria.setPublisherNames(publisherNames);

        return bookService.searchBooksByCriteria(criteria);
    }
    */
}
