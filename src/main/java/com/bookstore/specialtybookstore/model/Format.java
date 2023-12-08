package com.bookstore.specialtybookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Format")
public class Format {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdFormat")
    private int idFormat;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    public Format() {
    }

    public Format(int idFormat, String name) {
        this.idFormat = idFormat;
        this.name = name;
    }

    public int getIdFormat() {
        return idFormat;
    }

    public void setIdFormat(int idFormat) {
        this.idFormat = idFormat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Format [idFormat=" + idFormat + ", name=" + name + "]";
    }

}
