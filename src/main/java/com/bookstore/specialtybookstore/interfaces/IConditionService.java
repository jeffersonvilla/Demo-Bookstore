package com.bookstore.specialtybookstore.interfaces;

import java.util.List;

import com.bookstore.specialtybookstore.model.Condition;

public interface IConditionService {
    
    // CRUD operations
    public Condition createCondition(Condition condition);
    
    public Condition getConditionById(int id);
    
    public List<Condition> getAllConditions();
    
    public Condition updateCondition(Condition condition);
    
    public void deleteCondition(int id);
}
