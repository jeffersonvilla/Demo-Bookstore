package com.bookstore.specialtybookstore.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Book")
public class Book implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdBook")
    private int idBook;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "keywords", length = 255)
    private String keywords;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
        name = "BookGenre",
        joinColumns = @JoinColumn(name = "BookIdBook"),
        inverseJoinColumns = @JoinColumn(name = "GenreIdGenre")
    )
    private List<Genre> genres;

    @OneToMany(mappedBy = "book")
    private List<Edition> editions;

    public Book() {
    }

    public Book(int idBook, String title, String description, String keywords, List<Genre> genres) {
        this.idBook = idBook;
        this.title = title;
        this.description = description;
        this.keywords = keywords;
        this.genres = genres;
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
    
    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Book [idBook=" + idBook + ", title=" + title + ", description=" + description + ", keywords=" + keywords
                + "]";
    }

    
}
