package com.bookstore.specialtybookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.specialtybookstore.interfaces.ICoverTypeService;
import com.bookstore.specialtybookstore.model.CoverType;
import com.bookstore.specialtybookstore.repository.CoverTypeRepository;

@Service
public class CoverTypeService implements ICoverTypeService{
    
    private CoverTypeRepository repository;

    public CoverTypeService(CoverTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public CoverType createCoverType(CoverType coverType) {
        return this.repository.save(coverType);
    }

    @Override
    public CoverType getCoverTypeById(int id) {
        return this.repository.findById(id).get();
    }

    @Override
    public List<CoverType> getAllCoverTypes() {
        return this.repository.findAll();
    }

    @Override
    public CoverType updateCoverType(CoverType coverType) {
        return this.repository.save(coverType);
    }

    @Override
    public void deleteCoverType(int id) {
        this.repository.deleteById(id);
    }
}
