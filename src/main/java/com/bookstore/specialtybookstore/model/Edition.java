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

    @Column(name = "numberOfPages")
    private Integer numberOfPages;

    @Column(name = "dimensions", length = 50)
    private String dimensions;

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
    @JoinColumn(name = "IdFormat")
    private Format format;

    @ManyToOne
    @JoinColumn(name = "IdCoverType")
    private CoverType coverType;

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

    public Edition(int idEdition, Integer numberOfPages, String dimensions, String iSBN, Integer publicationYear,
            BigDecimal originalPrice, String illustrationsOrPlates, String limitedEditionSpecialFeatures,
            Language language, Format format, CoverType coverType, Book book, List<Publisher> publishers,
            List<Author> authors) {
        this.idEdition = idEdition;
        this.numberOfPages = numberOfPages;
        this.dimensions = dimensions;
        ISBN = iSBN;
        this.publicationYear = publicationYear;
        this.originalPrice = originalPrice;
        this.illustrationsOrPlates = illustrationsOrPlates;
        this.limitedEditionSpecialFeatures = limitedEditionSpecialFeatures;
        this.language = language;
        this.format = format;
        this.coverType = coverType;
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

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public CoverType getCoverType() {
        return coverType;
    }

    public void setCoverType(CoverType coverType) {
        this.coverType = coverType;
    }

    @Override
    public String toString() {
        return "Edition [idEdition=" + idEdition + ", numberOfPages=" + numberOfPages + ", dimensions=" + dimensions
                + ", ISBN=" + ISBN + ", publicationYear=" + publicationYear + ", originalPrice=" + originalPrice
                + ", illustrationsOrPlates=" + illustrationsOrPlates + ", limitedEditionSpecialFeatures="
                + limitedEditionSpecialFeatures + ", language=" + language + ", format=" + format + ", coverType="
                + coverType + ", book=" + book + ", publishers=" + publishers + ", authors=" + authors + "]";
    }

    

}
