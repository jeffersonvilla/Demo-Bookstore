package com.bookstore.specialtybookstore.interfaces;

import java.util.List;

import com.bookstore.specialtybookstore.model.Format;

public interface IFormatService {
    // CRUD operations
    public Format createFormat(Format format);
    
    public Format getFormatById(int id);
    
    public List<Format> getAllFormats();
    
    public Format updateFormat(Format format);
    
    public void deleteFormat(int id);
}
