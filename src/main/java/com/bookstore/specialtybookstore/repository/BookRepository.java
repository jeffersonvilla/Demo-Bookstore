package com.bookstore.specialtybookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookstore.specialtybookstore.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    
    @Query("SELECT a FROM Book a WHERE LOWER(a.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    public List<Book> searchBookByTitleLike(@Param("title") String title);
}
