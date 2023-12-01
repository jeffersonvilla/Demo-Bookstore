package com.bookstore.specialtybookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.specialtybookstore.model.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer>{
    
}
