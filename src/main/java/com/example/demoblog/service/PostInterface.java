package com.example.demoblog.service;

import com.example.demoblog.dto.PostCreateDTO;
import com.example.demoblog.dto.PostDTO;
import com.example.demoblog.dto.PostUpdateDTO;

import java.util.List;

public interface PostInterface {
    PostDTO createPost(PostCreateDTO postCreateDTO);
    List<PostDTO> getPost();
    void deletePostById(Long id);
    PostDTO updatePost(Long id, PostUpdateDTO postUpdateDTO);
}
