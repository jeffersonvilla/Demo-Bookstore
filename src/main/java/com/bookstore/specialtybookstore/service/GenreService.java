package com.bookstore.specialtybookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.specialtybookstore.interfaces.IGenreService;
import com.bookstore.specialtybookstore.model.Genre;
import com.bookstore.specialtybookstore.repository.GenreRepository;

@Service
public class GenreService implements IGenreService{
    
private GenreRepository repository;

    public GenreService(GenreRepository repository) {
        this.repository = repository;
    }

    @Override
    public Genre createGenre(Genre genre) {
        return this.repository.save(genre);
    }

    @Override
    public Genre getGenreById(int id) {
        return this.repository.findById(id).get();
    }

    @Override
    public List<Genre> getAllGenres() {
        return this.repository.findAll();
    }

    @Override
    public Genre updateGenre(Genre genre) {
        return this.repository.save(genre);
    }

    @Override
    public void deleteGenre(int id) {
        this.repository.deleteById(id);
    }

}
