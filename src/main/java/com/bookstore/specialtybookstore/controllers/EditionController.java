package com.bookstore.specialtybookstore.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.specialtybookstore.interfaces.IEditionService;
import com.bookstore.specialtybookstore.model.Edition;

@RestController
@RequestMapping("/api/v1/edition")
public class EditionController {

    private IEditionService editionService;    

    public EditionController(IEditionService editionService) {
        this.editionService = editionService;
    }

    @PostMapping
    public Edition createEdition(@RequestBody Edition edition) {
        return editionService.createEdition(edition);
    }

    @GetMapping("/{id}")
    public Edition getEditionById(@PathVariable int id) {
        return editionService.getEditionById(id);
    }

    @GetMapping
    public List<Edition> getAllEditions() {
        return editionService.getAllEditions();
    }

    @PutMapping("/{id}")
    public Edition updateEdition(@PathVariable int id, @RequestBody Edition edition) {
        edition.setIdEdition(id);
        return editionService.updateEdition(edition);
    }

    @DeleteMapping("/{id}")
    public void deleteEdition(@PathVariable int id) {
        editionService.deleteEdition(id);
    }

    
}

