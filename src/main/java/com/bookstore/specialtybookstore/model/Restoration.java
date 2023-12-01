package com.bookstore.specialtybookstore.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Restoration")
public class Restoration {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdRestoration")
    private int idRestoration;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "CopyIdCopy")
    private Copy copy;

    public Restoration() {
    }

    public Restoration(int idRestoration, LocalDate date, String description, Copy copy) {
        this.idRestoration = idRestoration;
        this.date = date;
        this.description = description;
        this.copy = copy;
    }

    public int getIdRestoration() {
        return idRestoration;
    }

    public void setIdRestoration(int idRestoration) {
        this.idRestoration = idRestoration;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    @Override
    public String toString() {
        return "Restoration [idRestoration=" + idRestoration + ", date=" + date + ", description=" + description
                + ", copy=" + copy + "]";
    }

    

}
