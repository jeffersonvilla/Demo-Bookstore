package com.bookstore.specialtybookstore.service;

import java.util.List;

import com.bookstore.specialtybookstore.interfaces.IRestorationService;
import com.bookstore.specialtybookstore.model.Restoration;
import com.bookstore.specialtybookstore.repository.RestorationRepository;

public class RestorationService implements IRestorationService{
    
    private RestorationRepository repository;

    public RestorationService(RestorationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Restoration createRestoration(Restoration restoration) {
        return this.repository.save(restoration);
    }

    @Override
    public Restoration getRestorationById(int id) {
        return this.repository.findById(id).get();
    }

    @Override
    public List<Restoration> getAllRestorations() {
        return this.repository.findAll();
    }

    @Override
    public Restoration updateRestoration(Restoration restoration) {
        return this.repository.save(restoration);
    }

    @Override
    public void deleteRestoration(int id) {
        this.repository.deleteById(id);
    }

    
}
