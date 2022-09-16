package com.codygym.repository;

import com.codygym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Modifying
    @Query(value = "update  Blog  set status = :status, type = :type, day=:day, title=:title where id = :id", nativeQuery = true)
    void update(@Param("status") String status, @Param("type") String type, @Param("day") String commit, @Param("title") String title, @Param("id") int id );


    @Query(value = "select * from Blog where title like :title", nativeQuery = true)
    Page<Blog> findByName(@Param("title") String title, Pageable pageable);


    Page<Blog> findAll(Pageable pageable);


}
