package com.bookstore.specialtybookstore.service;

import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.BOOK_CREATION_ERROR;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_EMPTY_TITLE;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_KEYWORDS_LENGTH_EXCEEDS;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_NULL_BOOK;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_TITLE_LENGTH_EXCEEDS;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_TITLE_REQUIRED;
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

        assertEquals(ERROR_NULL_BOOK, exception.getMessage());

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

        assertEquals(ERROR_EMPTY_TITLE, exception.getMessage());

        verify(mockRepository, times(0)).save(any());
    }

    @Test
    void createBook_InvalidBook_TooLargeTitle() {
        // Arrange
        Book invalidBook = new Book();
        invalidBook.setTitle("In the ethereal glow of moonlight, whispers of the night dance"+
        " through the mystic air. Shadows weave tales of forgotten dreams, while stars paint celestial"+
        " art upon the canvas of the cosmos. Time pauses, and the universe unveils its enigmatic "+
        "symphony, echoing the secrets of the infinite.");

        // Act and Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> bookService.createBook(invalidBook));

        assertEquals(ERROR_TITLE_LENGTH_EXCEEDS, exception.getMessage());

        verify(mockRepository, times(0)).save(any());
    }

    @Test
    void createBook_InvalidBook_TooLargeKeywords() {
        // Arrange
        Book invalidBook = new Book();
        invalidBook.setTitle("Title");
        invalidBook.setKeywords("In the ethereal glow of moonlight, whispers of the night dance"+
        " through the mystic air. Shadows weave tales of forgotten dreams, while stars paint celestial"+
        " art upon the canvas of the cosmos. Time pauses, and the universe unveils its enigmatic "+
        "symphony, echoing the secrets of the infinite.");

        // Act and Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> bookService.createBook(invalidBook));

        String thrownExceptionMessage = exception.getMessage();
        assertEquals(ERROR_KEYWORDS_LENGTH_EXCEEDS, thrownExceptionMessage);

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

        assertEquals(ERROR_TITLE_REQUIRED, exception.getMessage());

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
        assertEquals(BOOK_CREATION_ERROR, exception.getMessage());
    }
}
