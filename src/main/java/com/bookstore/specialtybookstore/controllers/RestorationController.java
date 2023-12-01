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

import com.bookstore.specialtybookstore.interfaces.IRestorationService;
import com.bookstore.specialtybookstore.model.Restoration;

@RestController
@RequestMapping("/api/v1/restoration")
public class RestorationController {

    private IRestorationService restorationService;    

    public RestorationController(IRestorationService restorationService) {
        this.restorationService = restorationService;
    }

    @PostMapping
    public Restoration createRestoration(@RequestBody Restoration restoration) {
        return restorationService.createRestoration(restoration);
    }

    @GetMapping("/{id}")
    public Restoration getRestorationById(@PathVariable int id) {
        return restorationService.getRestorationById(id);
    }

    @GetMapping
    public List<Restoration> getAllRestorations() {
        return restorationService.getAllRestorations();
    }

    @PutMapping("/{id}")
    public Restoration updateRestoration(@PathVariable int id, @RequestBody Restoration restoration) {
        restoration.setIdRestoration(id);
        return restorationService.updateRestoration(restoration);
    }

    @DeleteMapping("/{id}")
    public void deleteRestoration(@PathVariable int id) {
        restorationService.deleteRestoration(id);
    }

    
}
