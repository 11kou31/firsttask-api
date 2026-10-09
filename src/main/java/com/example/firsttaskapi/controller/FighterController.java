package com.example.firsttaskapi.controller;

import com.example.firsttaskapi.dto.Fighter;
import com.example.firsttaskapi.service.FighterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/fighters")
public class FighterController {

    private final FighterService fighterService;

    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    @GetMapping
    public ResponseEntity<List<Fighter>> findAllFighters() {
        List<Fighter> fighters = fighterService.findAll();

        return ResponseEntity.ok(fighters);
    }

    @PostMapping
    public ResponseEntity<Fighter> createFighter(@RequestBody Fighter fighter, UriComponentsBuilder uriBuilder) {
        fighterService.insert(fighter);

        URI location = uriBuilder.path("/api/fighters/{id}").buildAndExpand(fighter.getId()).toUri();
        return ResponseEntity.created(location).body(fighter);
    }
}