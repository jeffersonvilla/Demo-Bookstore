package com.bookstore.specialtybookstore.interfaces;

import java.util.List;

import com.bookstore.specialtybookstore.model.Publisher;

public interface IPublisherService {
    
    // CRUD operations
    public Publisher createPublisher(Publisher publisher);
    
    public Publisher getPublisherById(int id);
    
    public List<Publisher> getAllPublishers();
    
    public Publisher updatePublisher(Publisher publisher);
    
    public void deletePublisher(int id);

    // Search functionality
    public List<Publisher> searchPublisherByName(String name);
}
