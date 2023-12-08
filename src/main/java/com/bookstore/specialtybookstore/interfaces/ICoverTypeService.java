package com.bookstore.specialtybookstore.interfaces;

import java.util.List;

import com.bookstore.specialtybookstore.model.CoverType;

public interface ICoverTypeService {
    // CRUD operations
    public CoverType createCoverType(CoverType coverType);
    
    public CoverType getCoverTypeById(int id);
    
    public List<CoverType> getAllCoverTypes();
    
    public CoverType updateCoverType(CoverType coverType);
    
    public void deleteCoverType(int id);
    
}
