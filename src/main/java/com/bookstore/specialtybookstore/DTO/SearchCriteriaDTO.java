package com.bookstore.specialtybookstore.DTO;

import java.util.List;

public class SearchCriteriaDTO {
    
    private List<String> genreNames;

    private List<String> authorNames;

    public SearchCriteriaDTO() {
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
    
}
