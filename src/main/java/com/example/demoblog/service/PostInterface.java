package com.example.demoblog.service;

import com.example.demoblog.dto.PostCreateDTO;
import com.example.demoblog.dto.PostDTO;

import java.util.List;

public interface PostInterface {
    PostDTO createPost(PostCreateDTO postCreateDTO);
    List<PostDTO> getPost();
    void deleteById(Long id);
}
