package com.example.sportsbooking.controller;

import com.example.sportsbooking.model.Facility;
import com.example.sportsbooking.repository.FacilityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/facilities")
@CrossOrigin("*")
public class FacilityController {

    @Autowired
    private FacilityRepository repo;

    @GetMapping
    public Page<Facility> getAll(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "20") int size) {
        return repo.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/sport/{sport}")
    public Page<Facility> getBySport(@PathVariable String sport,
                                     @RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "20") int size) {
        return repo.findBySportType(sport, PageRequest.of(page, size));
    }
}