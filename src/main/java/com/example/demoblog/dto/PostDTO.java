package com.example.demoblog.dto;

import com.example.demoblog.model.PostEntity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class PostDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String title;
    private final String body;
    private final LocalDate createdAt;
    public PostDTO(String title, String body,LocalDate createdAt) {
        this.title = title;
        this.body = body;
        this.createdAt=createdAt;

    }
    public static PostDTO of(PostEntity post) {
        return new PostDTO(post.getTitle(),post.getBody(),
                post.getCreatedAt());
    }
}
