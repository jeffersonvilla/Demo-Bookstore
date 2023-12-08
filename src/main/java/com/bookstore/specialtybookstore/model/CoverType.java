package com.bookstore.specialtybookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CoverType")
public class CoverType {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCoverType")
    private int idCoverType;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    public CoverType() {
    }

    public CoverType(int idCoverType, String name) {
        this.idCoverType = idCoverType;
        this.name = name;
    }

    public int getIdCoverType() {
        return idCoverType;
    }

    public void setIdCoverType(int idCoverType) {
        this.idCoverType = idCoverType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CoverType [idCoverType=" + idCoverType + ", name=" + name + "]";
    }

}
