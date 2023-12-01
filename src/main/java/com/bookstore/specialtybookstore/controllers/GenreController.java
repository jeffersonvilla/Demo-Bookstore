package com.bookstore.specialtybookstore.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.specialtybookstore.interfaces.IGenreService;
import com.bookstore.specialtybookstore.model.Genre;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private IGenreService genreService;    

    public GenreController(IGenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping
    public Genre createGenre(@RequestBody Genre genre) {
        return genreService.createGenre(genre);
    }

    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable int id) {
        return genreService.getGenreById(id);
    }

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @PutMapping("/{id}")
    public Genre updateGenre(@PathVariable int id, @RequestBody Genre genre) {
        genre.setIdGenre(id);
        return genreService.updateGenre(genre);
    }

    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable int id) {
        genreService.deleteGenre(id);
    }

}
