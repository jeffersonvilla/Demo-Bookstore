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
@Table(name = "Publisher")
public class Publisher implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPublisher")
    private int idPublisher;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "contact_information", length = 255)
    private String contactInformation;

    @JsonBackReference
    @ManyToMany(mappedBy = "publishers")
    private List<Edition> editions;

    public Publisher() {
    }

    public Publisher(int idPublisher, String name, String address, String contactInformation, List<Edition> editions) {
        this.idPublisher = idPublisher;
        this.name = name;
        this.address = address;
        this.contactInformation = contactInformation;
        this.editions = editions;
    }

    public int getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(int idPublisher) {
        this.idPublisher = idPublisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public List<Edition> getEditions() {
        return editions;
    }

    public void setEditions(List<Edition> editions) {
        this.editions = editions;
    }

    @Override
    public String toString() {
        return "Publisher [idPublisher=" + idPublisher + ", name=" + name + ", address=" + address
                + ", contactInformation=" + contactInformation + "]";
    }

    
}
