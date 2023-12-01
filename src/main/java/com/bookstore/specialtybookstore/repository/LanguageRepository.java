package com.bookstore.specialtybookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.specialtybookstore.model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer>{
    
}
