package com.example.demoblog.controller;

import com.example.demoblog.GenericResponse;
import com.example.demoblog.dto.PostCreateDTO;
import com.example.demoblog.dto.PostDTO;
import com.example.demoblog.dto.PostUpdateDTO;
import com.example.demoblog.service.PostInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Main {
    private final PostInterface postInterface;

    @PostMapping("/v1/create")
    public ResponseEntity<?> createPost(@RequestBody PostCreateDTO postCreateDTO){
        postInterface.createPost(postCreateDTO);
        return ResponseEntity.ok(new GenericResponse("Post Created"));
    }

    @GetMapping("/v1/getAll")
    public ResponseEntity<List<PostDTO>> getAll(){
        final List<PostDTO>postDTOS=postInterface.getPost();
        return ResponseEntity.ok(postDTOS);
    }

    @DeleteMapping("/v1/delete/{id}")
    public ResponseEntity<?>deleteUserById(@PathVariable Long id){
        postInterface.deletePostById(id);
        return ResponseEntity.ok(new GenericResponse("user deleted"));
    }
    @PutMapping("/v1/update/{id}")
    public ResponseEntity<PostDTO>deleteByName(@PathVariable Long id , @RequestBody PostUpdateDTO postUpdateDTO){
        final PostDTO postDTO=postInterface.updatePost(id,postUpdateDTO);
        return ResponseEntity.ok(postDTO);
    }
}
