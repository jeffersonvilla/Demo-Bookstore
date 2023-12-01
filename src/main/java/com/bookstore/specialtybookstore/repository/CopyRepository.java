package com.bookstore.specialtybookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.specialtybookstore.model.Copy;

@Repository
public interface CopyRepository extends JpaRepository<Copy, Integer> {
    
}
