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

import com.bookstore.specialtybookstore.interfaces.IConditionService;
import com.bookstore.specialtybookstore.model.Condition;


@RestController
@RequestMapping("/api/v1/condition")
public class ConditionController {

    private IConditionService conditionService;    

    public ConditionController(IConditionService conditionService) {
        this.conditionService = conditionService;
    }

    @PostMapping
    public Condition createCondition(@RequestBody Condition condition) {
        return conditionService.createCondition(condition);
    }

    @GetMapping("/{id}")
    public Condition getConditionById(@PathVariable int id) {
        return conditionService.getConditionById(id);
    }

    @GetMapping
    public List<Condition> getAllConditions() {
        return conditionService.getAllConditions();
    }

    @PutMapping("/{id}")
    public Condition updateCondition(@PathVariable int id, @RequestBody Condition condition) {
        condition.setIdCondition(id);
        return conditionService.updateCondition(condition);
    }

    @DeleteMapping("/{id}")
    public void deleteCondition(@PathVariable int id) {
        conditionService.deleteCondition(id);
    }
    
}
