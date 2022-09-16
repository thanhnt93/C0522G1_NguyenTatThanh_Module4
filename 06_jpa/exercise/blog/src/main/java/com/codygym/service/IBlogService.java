package com.codygym.service;

import com.codygym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Optional<Blog> findById(int id);

    void update( Blog blog);

    void remove(int id);
    Page<Blog> findByName(String name, Pageable pageable);
    Page<Blog> findAll(Pageable pageable);
}
