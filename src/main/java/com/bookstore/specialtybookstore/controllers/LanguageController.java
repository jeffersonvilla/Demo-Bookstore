package com.bookstore.specialtybookstore.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.specialtybookstore.interfaces.ILanguageService;
import com.bookstore.specialtybookstore.model.Language;

@RestController
@RequestMapping("/api/v1/language")
public class LanguageController {

    private ILanguageService languageService;    

    public LanguageController(ILanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping
    public Language createLanguage(@RequestBody Language language) {
        return languageService.createLanguage(language);
    }

    @GetMapping("/{id}")
    public Language getLanguageById(@PathVariable int id) {
        return languageService.getLanguageById(id);
    }

    @GetMapping
    public List<Language> getAllLanguages() {
        return languageService.getAllLanguages();
    }

    @PutMapping("/{id}")
    public Language updateLanguage(@PathVariable int id, @RequestBody Language language) {
        language.setIdLanguage(id);
        return languageService.updateLanguage(language);
    }

    @DeleteMapping("/{id}")
    public void deleteLanguage(@PathVariable int id) {
        languageService.deleteLanguage(id);
    }

    @GetMapping("/search")
    public List<Language> searchLanguageByName(@RequestParam String name) {
        return languageService.searchLanguageByName(name);
    }
    
}
