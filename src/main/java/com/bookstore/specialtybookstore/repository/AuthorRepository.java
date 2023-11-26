package com.bookstore.specialtybookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookstore.specialtybookstore.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{
   
    @Query("SELECT a FROM Author a WHERE LOWER(a.authorName) LIKE LOWER(CONCAT('%', :name, '%'))")
    public List<Author> searchAuthorByNameLike(@Param("name") String name);

}
