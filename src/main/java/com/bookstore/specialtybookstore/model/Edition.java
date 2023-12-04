package com.bookstore.specialtybookstore.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Edition")
public class Edition implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEdition")
    private int idEdition;

    @Column(name = "format", length = 50)
    private String format;

    @Column(name = "numberOfPages")
    private Integer numberOfPages;

    @Column(name = "dimensions", length = 50)
    private String dimensions;

    @Column(name = "coverType", length = 50)
    private String coverType;

    @Column(name = "ISBN", nullable = false, length = 20)
    private String ISBN;

    @Column(name = "publicationYear")
    private Integer publicationYear;

    @Column(name = "originalPrice", precision = 10, scale = 2)
    private BigDecimal originalPrice;

    @Column(name = "IllustrationsOrPlates", length = 255)
    private String illustrationsOrPlates;

    @Column(name = "limitedEditionSpecialFeatures", length = 255)
    private String limitedEditionSpecialFeatures;

    @ManyToOne
    @JoinColumn(name = "IdLanguage")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "BookIdBook")
    private Book book;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
        name = "PublisherEdition",
        joinColumns = @JoinColumn(name = "EditionIdEdition"),
        inverseJoinColumns = @JoinColumn(name = "PublisherIdPublisher")
    )
    private List<Publisher> publishers;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
        name = "EditionAuthor",
        joinColumns = @JoinColumn(name = "EditionIdEdition"),
        inverseJoinColumns = @JoinColumn(name = "AuthorIdAuthor")
    )
    private List<Author> authors;

    public Edition() {
    }

    public Edition(int idEdition, String format, Integer numberOfPages, String dimensions, String coverType,
            String iSBN, Integer publicationYear, BigDecimal originalPrice, String illustrationsOrPlates,
            String limitedEditionSpecialFeatures, Language language, Book book, List<Publisher> publishers,
            List<Author> authors) {
        this.idEdition = idEdition;
        this.format = format;
        this.numberOfPages = numberOfPages;
        this.dimensions = dimensions;
        this.coverType = coverType;
        ISBN = iSBN;
        this.publicationYear = publicationYear;
        this.originalPrice = originalPrice;
        this.illustrationsOrPlates = illustrationsOrPlates;
        this.limitedEditionSpecialFeatures = limitedEditionSpecialFeatures;
        this.language = language;
        this.book = book;
        this.publishers = publishers;
        this.authors = authors;
    }

    public int getIdEdition() {
        return idEdition;
    }

    public void setIdEdition(int idEdition) {
        this.idEdition = idEdition;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getIllustrationsOrPlates() {
        return illustrationsOrPlates;
    }

    public void setIllustrationsOrPlates(String illustrationsOrPlates) {
        this.illustrationsOrPlates = illustrationsOrPlates;
    }

    public String getLimitedEditionSpecialFeatures() {
        return limitedEditionSpecialFeatures;
    }

    public void setLimitedEditionSpecialFeatures(String limitedEditionSpecialFeatures) {
        this.limitedEditionSpecialFeatures = limitedEditionSpecialFeatures;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }
    
    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Edition [idEdition=" + idEdition + ", format=" + format + ", numberOfPages=" + numberOfPages
                + ", dimensions=" + dimensions + ", coverType=" + coverType + ", ISBN=" + ISBN + ", publicationYear="
                + publicationYear + ", originalPrice=" + originalPrice + ", illustrationsOrPlates="
                + illustrationsOrPlates + ", limitedEditionSpecialFeatures=" + limitedEditionSpecialFeatures
                + ", language=" + language + ", book=" + book + "]";
    }

    

}
