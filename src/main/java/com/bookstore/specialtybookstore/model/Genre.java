package com.bookstore.specialtybookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Genre", schema = "dbo")
public class Genre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GenreID", nullable = false)
    private int genreId;

    @Column(name = "GenreName", nullable = false, length = 255)
    private String genreName;

    @Column(name = "Description")
    private String description;

    public Genre() {
    }

    public Genre(int genreId, String genreName, String description) {
        this.genreId = genreId;
        this.genreName = genreName;
        this.description = description;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Genre [genreId=" + genreId + ", genreName=" + genreName + ", description=" + description + "]";
    }

    
}
