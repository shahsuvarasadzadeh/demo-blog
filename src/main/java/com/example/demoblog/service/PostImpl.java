package com.example.demoblog.service;

import com.example.demoblog.GenericResponse;
import com.example.demoblog.dto.PostCreateDTO;
import com.example.demoblog.dto.PostDTO;
import com.example.demoblog.model.PostEntity;
import com.example.demoblog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostImpl implements PostInterface{

    private final PostRepository postRepository;
    @Override
    public PostDTO createPost(PostCreateDTO postCreateDTO) {
        final PostEntity postEntity;
        PostEntity postEntity1 = new PostEntity(postCreateDTO.getTitle(),
                postCreateDTO.getBody(),postCreateDTO.getCreatedAt());
        postEntity = postRepository.save(postEntity1);
        return PostDTO.of(postEntity);
    }

    @Override
    public List<PostDTO> getPost() {
        return postRepository.findAll().stream().
                map(PostDTO::of).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        final PostEntity postEntity=postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException())
    }
}
