package com.bookstore.specialtybookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookstore.specialtybookstore.model.Award;

@Repository
public interface AwardRepository extends JpaRepository<Award, Integer>{
    
    @Query("SELECT a FROM Award a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    public List<Award> searchAwardByNameLike(@Param("name") String name);
}
