package com.bookstore.specialtybookstore.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.specialtybookstore.interfaces.IAwardService;
import com.bookstore.specialtybookstore.model.Award;

@RestController
@RequestMapping("/api/v1/award")
public class AwardController {

    private IAwardService awardService;    

    public AwardController(IAwardService awardService) {
        this.awardService = awardService;
    }

    @PostMapping
    public Award createAward(@RequestBody Award award) {
        return awardService.createAward(award);
    }

    @GetMapping("/{id}")
    public Award getAwardById(@PathVariable int id) {
        return awardService.getAwardById(id);
    }

    @GetMapping
    public List<Award> getAllAwards() {
        return awardService.getAllAwards();
    }

    @PutMapping("/{id}")
    public Award updateAward(@PathVariable int id, @RequestBody Award award) {
        award.setIdAward(id);
        return awardService.updateAward(award);
    }

    @DeleteMapping("/{id}")
    public void deleteAward(@PathVariable int id) {
        awardService.deleteAward(id);
    }

    @GetMapping("/search")
    public List<Award> searchAwardByName(@RequestParam String name) {
        return awardService.searchAwardByName(name);
    }
    
}
