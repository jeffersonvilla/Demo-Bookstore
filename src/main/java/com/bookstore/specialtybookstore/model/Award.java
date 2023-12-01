package com.bookstore.specialtybookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Award")
public class Award {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAward")
    private int idAward;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "year")
    private Integer year;

    public Award() {
    }

    public Award(int idAward, String name, String description, Integer year) {
        this.idAward = idAward;
        this.name = name;
        this.description = description;
        this.year = year;
    }

    public int getIdAward() {
        return idAward;
    }

    public void setIdAward(int idAward) {
        this.idAward = idAward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Award [idAward=" + idAward + ", name=" + name + ", description=" + description + ", year=" + year + "]";
    }

    

}
