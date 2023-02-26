package com.example.demoblog.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PostCreateDTO {
    private String title;
    private String body;
    private LocalDate createdAt;
}
