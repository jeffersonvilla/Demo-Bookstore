package com.bookstore.specialtybookstore.service;

import java.util.List;

import com.bookstore.specialtybookstore.interfaces.IAwardService;
import com.bookstore.specialtybookstore.model.Award;
import com.bookstore.specialtybookstore.repository.AwardRepository;

public class AwardService implements IAwardService{
    
    private AwardRepository repository;

    public AwardService(AwardRepository repository) {
        this.repository = repository;
    }

    @Override
    public Award createAward(Award award) {
        return this.repository.save(award);
    }

    @Override
    public Award getAwardById(int id) {
        return this.repository.findById(id).get();
    }

    @Override
    public List<Award> getAllAwards() {
        return this.repository.findAll();
    }

    @Override
    public Award updateAward(Award award) {
        return this.repository.save(award);
    }

    @Override
    public void deleteAward(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<Award> searchAwardByName(String name) {
        return this.repository.searchAwardByNameLike(name);
    }
    
}
