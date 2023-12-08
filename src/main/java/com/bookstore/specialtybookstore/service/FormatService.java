package com.bookstore.specialtybookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.specialtybookstore.interfaces.IFormatService;
import com.bookstore.specialtybookstore.model.Format;
import com.bookstore.specialtybookstore.repository.FormatRepository;

@Service
public class FormatService implements IFormatService{
    
    private FormatRepository repository;

    public FormatService(FormatRepository repository) {
        this.repository = repository;
    }

    @Override
    public Format createFormat(Format format) {
        return this.repository.save(format);
    }

    @Override
    public Format getFormatById(int id) {
        return this.repository.findById(id).get();
    }

    @Override
    public List<Format> getAllFormats() {
        return this.repository.findAll();
    }

    @Override
    public Format updateFormat(Format format) {
        return this.repository.save(format);
    }

    @Override
    public void deleteFormat(int id) {
        this.repository.deleteById(id);
    }
}
