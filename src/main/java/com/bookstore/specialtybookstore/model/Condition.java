package com.bookstore.specialtybookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Condition")
public class Condition {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCondition")
    private int idCondition;

    @Column(name = "coverCondition", length = 50)
    private String coverCondition;

    @Column(name = "overallGrade", length = 50)
    private String overallGrade;

    @Column(name = "spineCondition", length = 50)
    private String spineCondition;

    @Column(name = "pagesCondition", length = 50)
    private String pagesCondition;

    @ManyToOne
    @JoinColumn(name = "CopyIdCopy")
    private Copy copy;

    public Condition() {
    }

    public Condition(int idCondition, String coverCondition, String overallGrade, String spineCondition,
            String pagesCondition, Copy copy) {
        this.idCondition = idCondition;
        this.coverCondition = coverCondition;
        this.overallGrade = overallGrade;
        this.spineCondition = spineCondition;
        this.pagesCondition = pagesCondition;
        this.copy = copy;
    }

    public int getIdCondition() {
        return idCondition;
    }

    public void setIdCondition(int idCondition) {
        this.idCondition = idCondition;
    }

    public String getCoverCondition() {
        return coverCondition;
    }

    public void setCoverCondition(String coverCondition) {
        this.coverCondition = coverCondition;
    }

    public String getOverallGrade() {
        return overallGrade;
    }

    public void setOverallGrade(String overallGrade) {
        this.overallGrade = overallGrade;
    }

    public String getSpineCondition() {
        return spineCondition;
    }

    public void setSpineCondition(String spineCondition) {
        this.spineCondition = spineCondition;
    }

    public String getPagesCondition() {
        return pagesCondition;
    }

    public void setPagesCondition(String pagesCondition) {
        this.pagesCondition = pagesCondition;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    @Override
    public String toString() {
        return "Condition [idCondition=" + idCondition + ", coverCondition=" + coverCondition + ", overallGrade="
                + overallGrade + ", spineCondition=" + spineCondition + ", pagesCondition=" + pagesCondition + ", copy="
                + copy + "]";
    }

    

}
