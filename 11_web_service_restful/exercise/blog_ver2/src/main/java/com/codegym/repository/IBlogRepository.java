package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog,Integer> {

//    @Modifying
//    @Query(value = "update  Blog  set status = :status," + " type = :type," + " day=:day where id = :id", nativeQuery = true)
//    void update(@Param("status") String status, @Param("type") String type, @Param("day") String commit, @Param("id") int id );
//
//??
    @Query(value = "select * from blog where status like %:status%", nativeQuery = true)
    List<Blog> findByNameContaining(@Param("status") String status);

}
