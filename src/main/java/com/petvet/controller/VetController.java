package com.petvet.controller;

import com.petvet.model.Vet;
import com.petvet.repository.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vets")
public class VetController {
    @Autowired
    private VetRepository vetRepository;

    @GetMapping
    public List<Vet> getAllVets() {
        return vetRepository.findAll();
    }

    @PostMapping
    public Vet createVet(@RequestBody Vet vet) {
        return vetRepository.save(vet);
    }

    @GetMapping("/{id}")
    public Vet getVetById(@PathVariable String id) {
        return vetRepository.findById(id).orElse(null);
    }
}

