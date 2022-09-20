package com.codegym.repository;

import com.codegym.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IMusicRepository extends JpaRepository<Music,Integer> {
    Page<Music> findByNameMusicContains(String name, Pageable pageable);
}
