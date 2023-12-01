package com.bookstore.specialtybookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.specialtybookstore.model.Edition;

@Repository
public interface EditionRepository extends JpaRepository<Edition, Integer>{
    
}
