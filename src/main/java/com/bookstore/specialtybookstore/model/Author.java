package com.bookstore.specialtybookstore.model;

import java.time.LocalDate;

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
    private int authorID;

    private String authorName;

    private LocalDate birthdate;

    private String nationality;

    public Author() {
    }

    public Author(int authorID, String authorName, LocalDate birthdate, String nationality) {
        this.authorID = authorID;
        this.authorName = authorName;
        this.birthdate = birthdate;
        this.nationality = nationality;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Author [authorID=" + authorID + ", authorName=" + authorName + ", birthdate=" + birthdate
                + ", nationality=" + nationality + "]";
    }
    
}
