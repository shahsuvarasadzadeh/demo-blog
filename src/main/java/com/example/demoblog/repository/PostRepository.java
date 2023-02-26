package com.example.demoblog.repository;

import com.example.demoblog.model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
