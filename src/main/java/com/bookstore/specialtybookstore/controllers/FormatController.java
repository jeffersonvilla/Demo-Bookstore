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

import com.bookstore.specialtybookstore.interfaces.IFormatService;
import com.bookstore.specialtybookstore.model.Format;

@RestController
@RequestMapping("/api/v1/format")
public class FormatController {
    private IFormatService formatService;    

    public FormatController(IFormatService formatService) {
        this.formatService = formatService;
    }

    @PostMapping
    public Format createFormat(@RequestBody Format format) {
        return formatService.createFormat(format);
    }

    @GetMapping("/{id}")
    public Format getFormatById(@PathVariable int id) {
        return formatService.getFormatById(id);
    }

    @GetMapping
    public List<Format> getAllFormats() {
        return formatService.getAllFormats();
    }

    @PutMapping("/{id}")
    public Format updateFormat(@PathVariable int id, @RequestBody Format format) {
        format.setIdFormat(id);
        return formatService.updateFormat(format);
    }

    @DeleteMapping("/{id}")
    public void deleteFormat(@PathVariable int id) {
        formatService.deleteFormat(id);
    }
}
