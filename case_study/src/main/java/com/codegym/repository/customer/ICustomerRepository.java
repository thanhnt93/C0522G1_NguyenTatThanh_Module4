package com.codegym.repository.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer where name like %:name%", nativeQuery = true)
    Page<Customer> findByNameContains(@Param("name") String name, Pageable pageable);

    Page<Customer> findAllByNameContaining(Pageable pageable, String name);
}
