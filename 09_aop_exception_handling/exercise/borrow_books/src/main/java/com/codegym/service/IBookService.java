package com.codegym.service;

import com.codegym.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);

    void save(Book book) throws Exception;

    Optional<Book> findById(int id);

    void payBook(Book book) throws Exception;

}
