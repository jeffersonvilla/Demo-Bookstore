package com.bookstore.specialtybookstore.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Author", schema = "dbo")
public class Author {

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

    public Author() {
    }

    public Author(int idAuthor, String name, LocalDate birthdate, LocalDate deathdate, String placeOfBirth,
            String placeOfDeath, String biography) {
        this.idAuthor = idAuthor;
        this.name = name;
        this.birthdate = birthdate;
        this.deathdate = deathdate;
        this.placeOfBirth = placeOfBirth;
        this.placeOfDeath = placeOfDeath;
        this.biography = biography;
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

    @Override
    public String toString() {
        return "Author [idAuthor=" + idAuthor + ", name=" + name + ", birthdate=" + birthdate + ", deathdate="
                + deathdate + ", placeOfBirth=" + placeOfBirth + ", placeOfDeath=" + placeOfDeath + ", biography="
                + biography + "]";
    }
    
}
