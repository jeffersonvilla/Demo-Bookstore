package com.bookstore.specialtybookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.specialtybookstore.model.Restoration;

@Repository
public interface RestorationRepository extends JpaRepository<Restoration, Integer>{
    
}
