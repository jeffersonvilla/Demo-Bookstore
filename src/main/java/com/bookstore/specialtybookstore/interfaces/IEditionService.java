package com.bookstore.specialtybookstore.interfaces;

import java.util.List;

import com.bookstore.specialtybookstore.model.Edition;

public interface IEditionService {
    
    // CRUD operations
    public Edition createEdition(Edition edition);
    
    public Edition getEditionById(int id);
    
    public List<Edition> getAllEditions();
    
    public Edition updateEdition(Edition edition);
    
    public void deleteEdition(int id);

}
