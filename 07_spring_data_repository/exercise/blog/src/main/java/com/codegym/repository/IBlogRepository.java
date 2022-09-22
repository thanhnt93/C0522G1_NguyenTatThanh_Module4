package com.codegym.repository;

import com.codegym.dto.BlogDto;
import com.codegym.model.Blog;
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
    @Query(value = "update  Blog  set status = :status, day=:day, author =:author where id = :id", nativeQuery = true)
    void update(@Param("status") String status, @Param("day") String commit, @Param("author") String author, @Param("id") int id );


    @Query(value = "select * from Blog where author like %:author%", nativeQuery = true)
    Page<Blog> findByName(@Param("author") String author,Pageable pageable);

    Page<Blog> findAll(Pageable pageable);

    @Query(value = "SELECT b.author as author, b.status as status, b.day as day, c.name as category " +
            "FROM blog b JOIN category c on b.id = c.id",
            nativeQuery= true)
    List<BlogDto> searchByAuthor();


}
