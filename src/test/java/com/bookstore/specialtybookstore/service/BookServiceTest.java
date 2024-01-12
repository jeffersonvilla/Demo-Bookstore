package com.bookstore.specialtybookstore.service;

import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.BOOK_CREATION_ERROR;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_EMPTY_TITLE;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_GETTING_ALL_BOOKS;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_GETTING_BOOK_BY_ID;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_INVALID_BOOK_ID;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_KEYWORDS_LENGTH_EXCEEDS;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_NULL_BOOK;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_TITLE_LENGTH_EXCEEDS;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_TITLE_REQUIRED;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.PAGEABLE_NULL_ERROR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bookstore.specialtybookstore.exceptions.BookCreationException;
import com.bookstore.specialtybookstore.exceptions.GetAllBooksException;
import com.bookstore.specialtybookstore.exceptions.GetBookByIdException;
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

    @Test
    void getAllBooks_Success() {
        // Arrange
        Pageable pageable = mock(Pageable.class);
        Page<Book> expectedPage = mock(Page.class);

        when(mockRepository.findAll(pageable)).thenReturn(expectedPage);

        // Act
        Page<Book> resultPage = bookService.getAllBooks(pageable);

        // Assert
        assertEquals(expectedPage, resultPage);
        verify(mockRepository, times(1)).findAll(pageable);
    }

    @Test
    void getAllBooks_ErrorInRepository() {
        // Arrange
        Pageable pageable = mock(Pageable.class);

        when(mockRepository.findAll(pageable)).thenThrow(new RuntimeException("Some error"));

        // Act and Assert
        GetAllBooksException thrownException = assertThrows(GetAllBooksException.class, 
                () -> bookService.getAllBooks(pageable));

        assertEquals(ERROR_GETTING_ALL_BOOKS, thrownException.getMessage());

        verify(mockRepository, times(1)).findAll(pageable);
    }

    @Test
    void getAllBooks_Error_NullPageable() {
        // Arrange
        Pageable pageable = null;

        // Act and Assert
        RuntimeException thrownException = assertThrows(RuntimeException.class, 
                () -> bookService.getAllBooks(pageable));

        assertEquals(PAGEABLE_NULL_ERROR, thrownException.getMessage());

        verify(mockRepository, times(0)).findAll(pageable);
    }

    @Test
    void getBookById_Error_Invalid_Book_Id(){
        //Arrange
        int bookId = -1;

        // Act and Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, () -> bookService.getBookById(bookId));

        assertEquals(ERROR_INVALID_BOOK_ID, exception.getMessage());   
    }

    @Test
    void getBookById_ErrorInRepository() {

        int bookId = 2;

        when(mockRepository.findById(any())).thenThrow(new RuntimeException("Simulated repository error"));

        // Act and Assert
        GetBookByIdException exception = assertThrows(GetBookByIdException.class,
                () -> bookService.getBookById(bookId));
                
        assertEquals(ERROR_GETTING_BOOK_BY_ID, exception.getMessage());
    }

    @Test
    void getBookById_Success(){
        //Arrange
        int bookId = 1;

        Book book = new Book();
        book.setIdBook(bookId);
        book.setTitle("Valid title");
    
        when(mockRepository.findById(any())).thenReturn(Optional.of(book));

        // Act
        Book createdBook = bookService.getBookById(bookId);

        // Assert
        assertNotNull(createdBook);
        assertEquals(book, createdBook);
        
        //Verify
        verify(mockRepository, times(1)).findById(any());
    }
}
