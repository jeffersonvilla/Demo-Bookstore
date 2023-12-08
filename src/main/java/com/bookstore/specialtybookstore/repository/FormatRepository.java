package com.bookstore.specialtybookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.specialtybookstore.model.Format;

public interface FormatRepository extends JpaRepository<Format, Integer>{
    
}
