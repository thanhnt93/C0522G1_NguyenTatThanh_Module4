package com.codegym.service.employee.impl;

import com.codegym.model.employee.Employee;
import com.codegym.repository.employee.IEmployeeRepository;
import com.codegym.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void removeVer2(int id) {
        employeeRepository.removerVer2(id);
    }

//    @Override
//    public Page<Employee> search(String name, Pageable pageInfo) {
//        return employeeRepository.findByNameContaining(name, pageInfo);
//    }

    @Override
    public Page<Employee> findAllByName(Pageable pageable, String name) {
        return employeeRepository.findAllByName(pageable, name);
    }
}
