package com.bookstore.specialtybookstore.interfaces;

import java.util.List;

import com.bookstore.specialtybookstore.model.Copy;

public interface ICopyService {
    
    // CRUD operations
    public Copy createCopy(Copy copy);
    
    public Copy getCopyById(int id);
    
    public List<Copy> getAllCopys();
    
    public Copy updateCopy(Copy copy);
    
    public void deleteCopy(int id);
}
