package com.bookstore.specialtybookstore.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.specialtybookstore.interfaces.IPublisherService;
import com.bookstore.specialtybookstore.model.Publisher;

@RestController
@RequestMapping("/api/v1/publisher")
public class PublisherController {

    private IPublisherService publisherService;    

    public PublisherController(IPublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping
    public Publisher createPublisher(@RequestBody Publisher publisher) {
        return publisherService.createPublisher(publisher);
    }

    @GetMapping("/{id}")
    public Publisher getPublisherById(@PathVariable int id) {
        return publisherService.getPublisherById(id);
    }

    @GetMapping
    public List<Publisher> getAllPublishers() {
        return publisherService.getAllPublishers();
    }

    @PutMapping("/{id}")
    public Publisher updatePublisher(@PathVariable int id, @RequestBody Publisher publisher) {
        publisher.setIdPublisher(id);
        return publisherService.updatePublisher(publisher);
    }

    @DeleteMapping("/{id}")
    public void deletePublisher(@PathVariable int id) {
        publisherService.deletePublisher(id);
    }

    @GetMapping("/search")
    public List<Publisher> searchPublisherByName(@RequestParam String name) {
        return publisherService.searchPublisherByName(name);
    }
    
}
