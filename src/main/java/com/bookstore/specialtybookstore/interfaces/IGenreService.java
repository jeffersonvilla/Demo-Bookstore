package com.bookstore.specialtybookstore.interfaces;

import java.util.List;

import com.bookstore.specialtybookstore.model.Genre;

public interface IGenreService {
    
    // CRUD operations
    public Genre createGenre(Genre genre);
    
    public Genre getGenreById(int id);
    
    public List<Genre> getAllGenres();
    
    public Genre updateGenre(Genre genre);
    
    public void deleteGenre(int id);

    // Search functionality
    //public List<Genre> searchGenreByName(String name);
}
