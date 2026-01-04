package com.example.jobboard.dtos;

public record JobDto(
        String title,
        String description,
        String location,
        Double salary,
        String companyName ) {}
