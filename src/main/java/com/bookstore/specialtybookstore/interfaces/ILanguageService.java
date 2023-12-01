package com.bookstore.specialtybookstore.interfaces;

import java.util.List;

import com.bookstore.specialtybookstore.model.Language;

public interface ILanguageService {
    
    // CRUD operations
    public Language createLanguage(Language language);
    
    public Language getLanguageById(int id);
    
    public List<Language> getAllLanguages();
    
    public Language updateLanguage(Language language);
    
    public void deleteLanguage(int id);

    // Search functionality
    public List<Language> searchLanguageByName(String name);
}
