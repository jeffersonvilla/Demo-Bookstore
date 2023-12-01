package com.bookstore.specialtybookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.specialtybookstore.model.Condition;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Integer>{
    
}
