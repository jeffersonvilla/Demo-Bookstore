package com.bookstore.specialtybookstore.mapper;

import org.springframework.stereotype.Component;

import com.bookstore.specialtybookstore.DTO.BookDTO;
import com.bookstore.specialtybookstore.model.Book;

@Component
public class BookMapper {

    public BookDTO toDTO(Book book){
        return new BookDTO(book.getIdBook(),book.getTitle(),book.getDescription(), book.getKeywords());
    }
    
    public Book toBook(BookDTO dto){
        return new Book(dto.getIdBook(), dto.getTitle(),dto.getDescription(), dto.getKeywords());
    }    
}
