package com.codegym.repository.impl;

import com.codegym.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategory extends JpaRepository<Category,Integer> {
}
