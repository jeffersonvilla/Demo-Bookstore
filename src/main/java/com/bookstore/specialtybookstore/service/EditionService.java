package com.bookstore.specialtybookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.specialtybookstore.interfaces.IEditionService;
import com.bookstore.specialtybookstore.model.Edition;
import com.bookstore.specialtybookstore.repository.EditionRepository;

@Service
public class EditionService implements IEditionService{

    private EditionRepository repository;

    public EditionService(EditionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Edition createEdition(Edition edition) {
        return this.repository.save(edition);
    }

    @Override
    public Edition getEditionById(int id) {
        return this.repository.findById(id).get();
    }

    @Override
    public List<Edition> getAllEditions() {
        return this.repository.findAll();
    }

    @Override
    public Edition updateEdition(Edition edition) {
        return this.repository.save(edition);
    }

    @Override
    public void deleteEdition(int id) {
        this.repository.deleteById(id);
    }
    
    
}
