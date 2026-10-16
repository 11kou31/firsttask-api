package com.example.firsttaskapi.service;

import com.example.firsttaskapi.dto.Fighter;
import com.example.firsttaskapi.exception.FighterArgumentNotValidException;
import com.example.firsttaskapi.exception.FighterNotFoundException;
import com.example.firsttaskapi.repository.FighterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FighterService {
    private final FighterRepository fighterRepository;

    public FighterService(FighterRepository fighterRepository) {
        this.fighterRepository = fighterRepository;
    }

    public List<Fighter> findAll() {
        return fighterRepository.findAll();
    }

    public void insert(Fighter fighter) {
        fighterRepository.insert(fighter);
    }

    public Fighter findById(Integer id) {
        Fighter fighter = fighterRepository.findById(id);

        if (fighter == null) {
            throw new FighterNotFoundException(id);
        }

        return fighter;
    }

    public boolean delete(Integer id) {
        if (!fighterRepository.delete(id)) {
            throw new FighterNotFoundException(id);
        }

        return true;
    }


    @Transactional
    public Fighter update(Fighter fighter, Integer id) {
        if (fighter.getName() == null || fighter.getName().isEmpty()) {
            throw new FighterArgumentNotValidException("name is empty");
        }

        Fighter targetFighter = fighterRepository.findById(id);
        if (targetFighter == null) {
            throw new FighterNotFoundException(id);
        }

        fighter.setId(id);
        return fighterRepository.update(fighter);
    }

}