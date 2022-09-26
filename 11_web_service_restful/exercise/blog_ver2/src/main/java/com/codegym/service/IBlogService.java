package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void update(int id, Blog blog);

    void remove(int id);

    List<Blog> findByNameContaining(String name);

}
