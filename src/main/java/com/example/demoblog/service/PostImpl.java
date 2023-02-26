package com.example.demoblog.service;

import com.example.demoblog.dto.PostCreateDTO;
import com.example.demoblog.dto.PostDTO;
import com.example.demoblog.dto.PostUpdateDTO;
import com.example.demoblog.exception.NotFoundException;
import com.example.demoblog.model.PostEntity;
import com.example.demoblog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public void deletePostById(Long id) {
        final PostEntity postEntity = postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("user not found"));
        postRepository.deleteById(postEntity.getId());
    }

    @Override
    public PostDTO updatePost(Long id, PostUpdateDTO postUpdateDTO) {
        final PostEntity postEntity=postRepository.
                findById(id).orElseThrow(() -> new NotFoundException("user not found"));
        postEntity.setTitle(postUpdateDTO.getTitle());
        postEntity.setBody(postUpdateDTO.getBody());

        PostEntity updatePost=postRepository.save(postEntity);
        return PostDTO.of(updatePost);
    }

}
