package com.bookstore.specialtybookstore.exceptions;

public class BookCreationException extends RuntimeException {

    public BookCreationException(String message) {
        super(message);
    }

    public BookCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}

