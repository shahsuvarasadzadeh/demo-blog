package com.example.demoblog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "Post")
@Data
@AllArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "Text_title")
    private String title;
    @Column(name = "Text")
    private String body;
    @Column(name = "created_date")
    private LocalDate createdAt;
    public PostEntity(String title, String body,LocalDate createdAt) {
        this.title = title;
        this.body = body;
        this.createdAt=createdAt;
    }
}
