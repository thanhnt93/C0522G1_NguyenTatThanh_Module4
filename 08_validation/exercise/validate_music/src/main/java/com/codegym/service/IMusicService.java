package com.codegym.service;

import com.codegym.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IMusicService {
    Page<Music> findAll(Pageable pageable);

    void save(Music music);

    Optional<Music> findById(int id);

    void remove(int id);

    Page<Music> search(String name, Pageable pageInfo);
}
