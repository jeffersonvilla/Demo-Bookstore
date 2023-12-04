package com.bookstore.specialtybookstore.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Author", schema = "dbo")
public class Author implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAuthor")
    private int idAuthor;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "deathdate")
    private LocalDate deathdate;

    @Column(name = "placeOfBirth", length = 255)
    private String placeOfBirth;

    @Column(name = "placeOfDeath", length = 255)
    private String placeOfDeath;

    @Column(name = "Biography", columnDefinition = "TEXT")
    private String biography;

    @JsonBackReference
    @ManyToMany(mappedBy = "authors")
    private List<Edition> editions;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
        name = "AuthorAward",
        joinColumns = @JoinColumn(name = "AuthorIdAuthor"),
        inverseJoinColumns = @JoinColumn(name = "AwardIdAward")
    )
    private List<Award> awards;

    public Author() {
    }

    public Author(int idAuthor, String name, LocalDate birthdate, LocalDate deathdate, String placeOfBirth,
            String placeOfDeath, String biography, List<Edition> editions, List<Award> awards) {
        this.idAuthor = idAuthor;
        this.name = name;
        this.birthdate = birthdate;
        this.deathdate = deathdate;
        this.placeOfBirth = placeOfBirth;
        this.placeOfDeath = placeOfDeath;
        this.biography = biography;
        this.editions = editions;
        this.awards = awards;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public LocalDate getDeathdate() {
        return deathdate;
    }

    public void setDeathdate(LocalDate deathdate) {
        this.deathdate = deathdate;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getPlaceOfDeath() {
        return placeOfDeath;
    }

    public void setPlaceOfDeath(String placeOfDeath) {
        this.placeOfDeath = placeOfDeath;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Edition> getEditions() {
        return editions;
    }

    public void setEditions(List<Edition> editions) {
        this.editions = editions;
    }
    
    public List<Award> getAwards() {
        return awards;
    }

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }
    
    @Override
    public String toString() {
        return "Author [idAuthor=" + idAuthor + ", name=" + name + ", birthdate=" + birthdate + ", deathdate="
                + deathdate + ", placeOfBirth=" + placeOfBirth + ", placeOfDeath=" + placeOfDeath + ", biography="
                + biography + "]";
    }
    
}
