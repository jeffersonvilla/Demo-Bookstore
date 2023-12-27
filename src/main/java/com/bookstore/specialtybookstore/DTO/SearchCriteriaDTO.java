package com.bookstore.specialtybookstore.DTO;

import java.util.List;

public class SearchCriteriaDTO {

    private String title;

    private String descriptionText;
    
    private List<String> genreNames;

    private List<String> authorNames;

    private List<String> publisherNames;

    public SearchCriteriaDTO() {
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    public List<String> getGenreNames() {
        return genreNames;
    }

    public void setGenreNames(List<String> genreNames) {
        this.genreNames = genreNames;
    }

    public List<String> getAuthorNames() {
        return authorNames;
    }

    public void setAuthorNames(List<String> authorNames) {
        this.authorNames = authorNames;
    }

    public List<String> getPublisherNames() {
        return publisherNames;
    }

    public void setPublisherNames(List<String> publisherNames) {
        this.publisherNames = publisherNames;
    }
    
}
