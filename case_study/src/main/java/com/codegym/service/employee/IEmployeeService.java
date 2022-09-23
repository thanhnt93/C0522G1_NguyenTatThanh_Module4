package com.codegym.service.employee;

import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService{
    Page<Employee> findAll(Pageable pageable);

    void save(Employee employee);

    Optional<Employee> findById(int id);

    void removeVer2(int id);

//    Page<Employee> search(String name, Pageable pageInfo);

    Page<Employee> findAllByName(Pageable pageable, String name);
}
