package com.example.firsttaskapi.mapper;

import com.example.firsttaskapi.dto.Fighter;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FighterMapper {

    @Select("SELECT id, name, age, weight_class, wins, losses FROM fighters ORDER BY id")
    List<Fighter> findAll();

    @Insert("INSERT INTO fighters (name, age, weight_class, wins, losses) VALUES (#{name}, #{age}, #{weightClass},#{wins}, #{losses})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Fighter fighter);

    @Select("SELECT id, name, age, weight_class, wins, losses FROM fighters WHERE id = #{id}")
    Fighter findById(Integer id);

    @Delete("DELETE FROM fighters WHERE id = #{id}")
    int delete(Integer id);
}