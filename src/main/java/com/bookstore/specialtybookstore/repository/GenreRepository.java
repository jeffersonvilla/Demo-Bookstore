package com.bookstore.specialtybookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookstore.specialtybookstore.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>{
    
    @Query("SELECT a FROM Genre a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    public List<Genre> searchGenreByNameLike(@Param("name") String name);
}
