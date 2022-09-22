package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable,String name);

    void save(Customer customer);

    Optional<Customer> findById(int id);

    void remove(int id);

    Page<Customer> findByNameContains(String name, Pageable pageInfo);

    List<Customer> findAll();
}
