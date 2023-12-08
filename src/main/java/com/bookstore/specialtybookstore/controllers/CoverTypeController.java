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

import com.bookstore.specialtybookstore.interfaces.ICoverTypeService;
import com.bookstore.specialtybookstore.model.CoverType;

@RestController
@RequestMapping("/api/v1/coverType")
public class CoverTypeController {

    private ICoverTypeService coverTypeService;    

    public CoverTypeController(ICoverTypeService coverTypeService) {
        this.coverTypeService = coverTypeService;
    }

    @PostMapping
    public CoverType createCoverType(@RequestBody CoverType coverType) {
        return coverTypeService.createCoverType(coverType);
    }

    @GetMapping("/{id}")
    public CoverType getCoverTypeById(@PathVariable int id) {
        return coverTypeService.getCoverTypeById(id);
    }

    @GetMapping
    public List<CoverType> getAllCoverTypes() {
        return coverTypeService.getAllCoverTypes();
    }

    @PutMapping("/{id}")
    public CoverType updateCoverType(@PathVariable int id, @RequestBody CoverType coverType) {
        coverType.setIdCoverType(id);
        return coverTypeService.updateCoverType(coverType);
    }

    @DeleteMapping("/{id}")
    public void deleteCoverType(@PathVariable int id) {
        coverTypeService.deleteCoverType(id);
    }
}
