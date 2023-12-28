package com.bookstore.specialtybookstore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookstore.specialtybookstore.exceptions.BookCreationException;
import com.bookstore.specialtybookstore.model.Book;
import com.bookstore.specialtybookstore.repository.BookRepository;


@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository mockRepository;

    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookService(mockRepository);
    }

    @Test
    void createBook_SuccessfulCreation() {
        // Arrange
        Book validBook = new Book();
        validBook.setTitle("Valid title");
        when(mockRepository.save(any(Book.class))).thenReturn(validBook);

        // Act
        Book createdBook = bookService.createBook(validBook);

        // Assert
        assertNotNull(createdBook);
        assertEquals(validBook, createdBook);
        
        //Verify
        verify(mockRepository, times(1)).save(any());
    }

    @Test
    void createBook_InvalidBook_NullArgument() {
        // Arrange
        Book invalidBook = null;

        // Act and Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> bookService.createBook(invalidBook));

        assertEquals("The book is not valid", exception.getMessage());

        verify(mockRepository, times(0)).save(any());
    }

    @Test
    void createBook_InvalidBook_BlankTitle() {
        // Arrange
        Book invalidBook = new Book();
        invalidBook.setTitle("");

        // Act and Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> bookService.createBook(invalidBook));

        assertEquals("The book is not valid", exception.getMessage());

        verify(mockRepository, times(0)).save(any());
    }

    @Test
    void createBook_InvalidBook_NullTitle() {
        // Arrange
        Book invalidBook = new Book();

        // Act and Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> bookService.createBook(invalidBook));

        assertEquals("The book is not valid", exception.getMessage());

        verify(mockRepository, times(0)).save(any());
    }

    @Test
    void createBook_ErrorInRepository() {
        // Arrange
        Book validBook = new Book();
        validBook.setTitle("Valid title");
        when(mockRepository.save(any(Book.class))).thenThrow(new RuntimeException("Simulated repository error"));

        // Act and Assert
        BookCreationException exception = assertThrows(BookCreationException.class,
                () -> bookService.createBook(validBook));
        assertEquals("Error creating the book", exception.getMessage());
    }
}
