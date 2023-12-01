package com.bookstore.specialtybookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.specialtybookstore.interfaces.ILanguageService;
import com.bookstore.specialtybookstore.model.Language;
import com.bookstore.specialtybookstore.repository.LanguageRepository;

@Service
public class LanguageService implements ILanguageService{
    
    private LanguageRepository repository;

    public LanguageService(LanguageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Language createLanguage(Language language) {
        return this.repository.save(language);
    }

    @Override
    public Language getLanguageById(int id) {
        return this.repository.findById(id).get();
    }

    @Override
    public List<Language> getAllLanguages() {
        return this.repository.findAll();
    }

    @Override
    public Language updateLanguage(Language language) {
        return this.repository.save(language);
    }

    @Override
    public void deleteLanguage(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<Language> searchLanguageByName(String name) {
        return this.repository.searchLanguageByNameLike(name);
    }
    
}
