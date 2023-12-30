package com.bookstore.specialtybookstore.exceptions;

public class GetAllBooksException extends RuntimeException{

    public GetAllBooksException(String message) {
        super(message);
    }

    public GetAllBooksException(String message, Throwable cause) {
        super(message, cause);
    }
}
