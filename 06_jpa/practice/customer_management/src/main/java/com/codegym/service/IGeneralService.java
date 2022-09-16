package com.codegym.service;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();

    T findById(int id);

    void save(T t);

    void remove(int id);
}
