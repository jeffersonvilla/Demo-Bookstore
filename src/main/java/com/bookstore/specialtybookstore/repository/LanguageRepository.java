package com.bookstore.specialtybookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookstore.specialtybookstore.model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer>{
    
    @Query("SELECT a FROM Language a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    public List<Language> searchLanguageByNameLike(@Param("name") String name);
}
