package com.example.firsttaskapi.dto;

import lombok.Data;

@Data
public class Fighter {
    private Integer id;
    private String name;
    private Integer age;
    private String weightClass;
    private Integer wins;
    private Integer losses;
}
