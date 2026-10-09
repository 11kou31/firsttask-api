package com.example.firsttaskapi.repository;

import com.example.firsttaskapi.dto.Fighter;
import com.example.firsttaskapi.mapper.FighterMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FighterRepository {

    private final FighterMapper fighterMapper;

    public FighterRepository(FighterMapper fighterMapper) {
        this.fighterMapper = fighterMapper;
    }

    public List<Fighter> findAll() {
        return fighterMapper.findAll();
    }
}