package com.bookstore.specialtybookstore.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Copy")
public class Copy {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCopy")
    private int idCopy;

    @Column(name = "additionalNotes", columnDefinition = "TEXT")
    private String additionalNotes;

    @Column(name = "specialFeatures", columnDefinition = "TEXT")
    private String specialFeatures;

    @Column(name = "signatures", length = 255)
    private String signatures;

    @Column(name = "image", length = 255)
    private String image;

    @Column(name = "rarityLevel", length = 50)
    private String rarityLevel;

    @Column(name = "marketValue", precision = 10, scale = 2)
    private BigDecimal marketValue;

    @Column(name = "provenance", columnDefinition = "TEXT")
    private String provenance;

    @Column(name = "inscriptions", columnDefinition = "TEXT")
    private String inscriptions;

    @Column(name = "odorDetails", columnDefinition = "TEXT")
    private String odorDetails;

    @ManyToOne
    @JoinColumn(name = "EditionIdEdition")
    private Edition edition;

    public Copy() {
    }

    public Copy(int idCopy, String additionalNotes, String specialFeatures, String signatures, String image,
            String rarityLevel, BigDecimal marketValue, String provenance, String inscriptions, String odorDetails,
            Edition edition) {
        this.idCopy = idCopy;
        this.additionalNotes = additionalNotes;
        this.specialFeatures = specialFeatures;
        this.signatures = signatures;
        this.image = image;
        this.rarityLevel = rarityLevel;
        this.marketValue = marketValue;
        this.provenance = provenance;
        this.inscriptions = inscriptions;
        this.odorDetails = odorDetails;
        this.edition = edition;
    }

    public int getIdCopy() {
        return idCopy;
    }

    public void setIdCopy(int idCopy) {
        this.idCopy = idCopy;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public String getSignatures() {
        return signatures;
    }

    public void setSignatures(String signatures) {
        this.signatures = signatures;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRarityLevel() {
        return rarityLevel;
    }

    public void setRarityLevel(String rarityLevel) {
        this.rarityLevel = rarityLevel;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public String getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(String inscriptions) {
        this.inscriptions = inscriptions;
    }

    public String getOdorDetails() {
        return odorDetails;
    }

    public void setOdorDetails(String odorDetails) {
        this.odorDetails = odorDetails;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "Copy [idCopy=" + idCopy + ", additionalNotes=" + additionalNotes + ", specialFeatures="
                + specialFeatures + ", signatures=" + signatures + ", image=" + image + ", rarityLevel=" + rarityLevel
                + ", marketValue=" + marketValue + ", provenance=" + provenance + ", inscriptions=" + inscriptions
                + ", odorDetails=" + odorDetails + ", edition=" + edition + "]";
    }

    
}
