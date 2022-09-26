package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category/api/v1")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategoryList() {
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addBlog(@RequestBody Category category) {
        Category category1 = new Category();
        BeanUtils.copyProperties(category, category1);
        categoryService.save(category1);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateBlog(@PathVariable int id, @RequestBody Category category) {
        Category category1 = categoryService.findById(id);
        if (category1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        category1.setName(category.getName());
        categoryService.save(category1);
        return new ResponseEntity<>(category1, HttpStatus.OK);
    }
}
