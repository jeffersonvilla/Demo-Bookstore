package com.bookstore.specialtybookstore.interfaces;

import java.util.List;

import com.bookstore.specialtybookstore.model.Award;

public interface IAwardService {
    
    // CRUD operations
    public Award createAward(Award award);
    
    public Award getAwardById(int id);
    
    public List<Award> getAllAwards();
    
    public Award updateAward(Award award);
    
    public void deleteAward(int id);

    // Search functionality
    public List<Award> searchAwardByName(String name);
}
