package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog/api/v1")
public class BlogRestController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> getBlogList() {
        List<Blog> blogListb = blogService.findAll();
        if (blogListb.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogListb, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addBlog(@RequestBody Blog blog) {
        Blog blog1 = new Blog();
        BeanUtils.copyProperties(blog, blog1);
        blogService.save(blog1);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable int id, @RequestBody Blog blog) {
        Blog blog1 = blogService.findById(id);
        if (blog1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog1.setStatus(blog.getStatus());
        blog1.setAuthor(blog.getAuthor());
        blog1.setDay(blog.getDay());
        blog1.setCategory(blog.getCategory());
        blogService.save(blog1);
        return new ResponseEntity<>(blog1, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> detail(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
