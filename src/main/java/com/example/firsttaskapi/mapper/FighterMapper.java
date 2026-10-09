package com.example.firsttaskapi.mapper;

import com.example.firsttaskapi.dto.Fighter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FighterMapper {

    @Select("SELECT id, name, age, weight_class, wins, losses FROM fighters ORDER BY id")
    List<Fighter> findAll();
}