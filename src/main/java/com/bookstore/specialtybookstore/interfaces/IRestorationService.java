package com.bookstore.specialtybookstore.interfaces;

import java.util.List;

import com.bookstore.specialtybookstore.model.Restoration;

public interface IRestorationService {
    
    // CRUD operations
    public Restoration createRestoration(Restoration restoration);
    
    public Restoration getRestorationById(int id);
    
    public List<Restoration> getAllRestorations();
    
    public Restoration updateRestoration(Restoration restoration);
    
    public void deleteRestoration(int id);
}
