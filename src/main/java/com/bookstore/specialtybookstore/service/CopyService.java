package com.bookstore.specialtybookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.specialtybookstore.interfaces.ICopyService;
import com.bookstore.specialtybookstore.model.Copy;
import com.bookstore.specialtybookstore.repository.CopyRepository;

@Service
public class CopyService implements ICopyService{
    
    private CopyRepository repository;

    public CopyService(CopyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Copy createCopy(Copy copy) {
        return this.repository.save(copy);
    }

    @Override
    public Copy getCopyById(int id) {
        return this.repository.findById(id).get();
    }

    @Override
    public List<Copy> getAllCopys() {
        return this.repository.findAll();
    }

    @Override
    public Copy updateCopy(Copy copy) {
        return this.repository.save(copy);
    }

    @Override
    public void deleteCopy(int id) {
        this.repository.deleteById(id);
    }

    
}
