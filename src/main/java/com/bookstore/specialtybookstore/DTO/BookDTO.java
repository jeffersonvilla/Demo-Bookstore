package com.bookstore.specialtybookstore.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BookDTO {
    
    private int idBook;

    @NotBlank(message = "The book's title cannot be blank")
    @Size(min = 2, message = "The book should have a title with at least 2 characters")
    @Size(max = 255, message = "The book should have a title with maximum 255 characters")
    private String title;

    private String description;

    @Size(max = 255, message = "The book's keywords should have a maximum of 255 characters")
    private String keywords;

    public BookDTO() {
    }

    public BookDTO(String title, String description, String keywords) {
        this.title = title;
        this.description = description;
        this.keywords = keywords;
    }

    public BookDTO(int idBook, String title, String description, String keywords) {
        this.idBook = idBook;
        this.title = title;
        this.description = description;
        this.keywords = keywords;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

}
