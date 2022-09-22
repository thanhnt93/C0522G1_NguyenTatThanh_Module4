package com.codegym.repository.employee;

import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "select * from employee where name like :search", nativeQuery= true)
    Page<Employee> findByNameContaining(@Param("search") String name, Pageable pageable);


    @Query(value = "select * from employee where is_delete = 0", nativeQuery= true)
    Page<Employee> findAll2(Pageable pageable);


    @Modifying
    @Query(value = "update employee set is_delete = 1 where id=:id ", nativeQuery= true)
    void removerVer2(@Param("id") Integer id);



}
