package com.bookstore.specialtybookstore.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Language")
public class Language implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdLanguage")
    private int idLanguage;
    
    @Column(name = "name", length = 50)
    private String name;

    public Language() {
    }

    public Language(int idLanguage, String name) {
        this.idLanguage = idLanguage;
        this.name = name;
    }
    
    public int getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(int idLanguage) {
        this.idLanguage = idLanguage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Language [idLanguage=" + idLanguage + ", name=" + name + "]";
    }

}
