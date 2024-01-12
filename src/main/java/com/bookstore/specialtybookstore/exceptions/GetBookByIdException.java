package com.bookstore.specialtybookstore.exceptions;

public class GetBookByIdException extends RuntimeException {

    public GetBookByIdException(String message){
        super(message);
    }

    public GetBookByIdException(String message, Throwable cause){
        super(message, cause);
    }
    
}
