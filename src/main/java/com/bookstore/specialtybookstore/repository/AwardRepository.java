package com.bookstore.specialtybookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.specialtybookstore.model.Award;

@Repository
public interface AwardRepository extends JpaRepository<Award, Integer>{
    
}
