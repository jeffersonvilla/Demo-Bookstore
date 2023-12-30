package com.bookstore.specialtybookstore.exceptions.error_messages;

public class ExceptionMessages {
    public static final String ERROR_NULL_BOOK = "The book should not be null";
    public static final String ERROR_EMPTY_TITLE = "The book title should not be blank";
    public static final String ERROR_TITLE_REQUIRED = "The book title is required";
    public static final String ERROR_TITLE_LENGTH_EXCEEDS = "The book title length exceeds the maximum allowed (255 characters)";
    public static final String ERROR_KEYWORDS_LENGTH_EXCEEDS = "The keywords length exceeds the maximum allowed (255 characters)";
    public static final String BOOK_CREATION_ERROR = "Error creating the book";
    public static final String ERROR_GETTING_ALL_BOOKS = "Failed to retrieve all books from the database.";
    
    public static final String PAGEABLE_NULL_ERROR = "The pageable can't be null";
}
