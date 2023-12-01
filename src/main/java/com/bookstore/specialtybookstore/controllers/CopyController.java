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

import com.bookstore.specialtybookstore.interfaces.ICopyService;
import com.bookstore.specialtybookstore.model.Copy;

@RestController
@RequestMapping("/api/v1/copy")
public class CopyController {

    private ICopyService copyService;    

    public CopyController(ICopyService copyService) {
        this.copyService = copyService;
    }

    @PostMapping
    public Copy createCopy(@RequestBody Copy copy) {
        return copyService.createCopy(copy);
    }

    @GetMapping("/{id}")
    public Copy getCopyById(@PathVariable int id) {
        return copyService.getCopyById(id);
    }

    @GetMapping
    public List<Copy> getAllCopys() {
        return copyService.getAllCopys();
    }

    @PutMapping("/{id}")
    public Copy updateCopy(@PathVariable int id, @RequestBody Copy copy) {
        copy.setIdCopy(id);
        return copyService.updateCopy(copy);
    }

    @DeleteMapping("/{id}")
    public void deleteCopy(@PathVariable int id) {
        copyService.deleteCopy(id);
    }
    
}
