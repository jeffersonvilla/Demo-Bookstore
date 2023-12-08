package com.bookstore.specialtybookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.specialtybookstore.model.CoverType;

public interface CoverTypeRepository extends JpaRepository<CoverType, Integer>{
    
}
