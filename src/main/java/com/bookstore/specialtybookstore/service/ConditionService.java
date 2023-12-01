package com.bookstore.specialtybookstore.service;

import java.util.List;

import com.bookstore.specialtybookstore.interfaces.IConditionService;
import com.bookstore.specialtybookstore.model.Condition;
import com.bookstore.specialtybookstore.repository.ConditionRepository;

public class ConditionService implements IConditionService{
    
    private ConditionRepository repository;

    public ConditionService(ConditionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Condition createCondition(Condition condition) {
        return this.repository.save(condition);
    }

    @Override
    public Condition getConditionById(int id) {
        return this.repository.findById(id).get();
    }

    @Override
    public List<Condition> getAllConditions() {
        return this.repository.findAll();
    }

    @Override
    public Condition updateCondition(Condition condition) {
        return this.repository.save(condition);
    }

    @Override
    public void deleteCondition(int id) {
        this.repository.deleteById(id);
    }

    
}
