package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.repository.IBookRepository;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public void save(Book book) throws Exception {
        Book book1 = findById(book.getId()).get();
        if (book1.getNumber() >= 0) {
            if (book1.getTotal() == book1.getNumber()) {
                throw new Exception();
            }
            book1.setNumber(book1.getNumber() + 1);
            bookRepository.save(book1);
        }
    }

    @Override
    public Optional<Book> findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void payBook(Book book) throws Exception {
        Book book1 = findById(book.getId()).get();
        if (book1.getNumber() > 0) {
            book1.setNumber(book1.getNumber() - 1);
            bookRepository.save(book1);
        } else if (book1.getNumber() == 0) {
            throw new Exception();
        }
    }

}
