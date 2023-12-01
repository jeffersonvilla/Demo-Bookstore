package com.bookstore.specialtybookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.specialtybookstore.interfaces.IPublisherService;
import com.bookstore.specialtybookstore.model.Publisher;
import com.bookstore.specialtybookstore.repository.PublisherRepository;

@Service
public class PublisherService implements IPublisherService{
    
    private PublisherRepository repository;

    public PublisherService(PublisherRepository repository) {
        this.repository = repository;
    }

    @Override
    public Publisher createPublisher(Publisher publisher) {
        return this.repository.save(publisher);
    }

    @Override
    public Publisher getPublisherById(int id) {
        return this.repository.findById(id).get();
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return this.repository.findAll();
    }

    @Override
    public Publisher updatePublisher(Publisher publisher) {
        return this.repository.save(publisher);
    }

    @Override
    public void deletePublisher(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<Publisher> searchPublisherByName(String name) {
        return this.repository.searchPublisherByNameLike(name);
    }
    
}
