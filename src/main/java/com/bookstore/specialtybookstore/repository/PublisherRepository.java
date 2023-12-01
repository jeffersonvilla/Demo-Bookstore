package com.bookstore.specialtybookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookstore.specialtybookstore.model.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer>{
    
    @Query("SELECT a FROM Publisher a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    public List<Publisher> searchPublisherByNameLike(@Param("name") String name);
}
