package com.bookstore.specialtybookstore.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Award")
public class Award implements Serializable{
    
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

    @JsonBackReference
    @ManyToMany(mappedBy = "awards")
    private List<Author> authors;

    public Award() {
    }

    public Award(int idAward, String name, String description, Integer year, List<Author> authors) {
        this.idAward = idAward;
        this.name = name;
        this.description = description;
        this.year = year;
        this.authors = authors;
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
    
    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Award [idAward=" + idAward + ", name=" + name + ", description=" + description + ", year=" + year + "]";
    }

    

}
