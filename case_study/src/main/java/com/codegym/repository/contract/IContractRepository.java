package com.codegym.repository.contract;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select * from contract where name like %:search%", nativeQuery = true)
    Page<Contract> findByNameContaining(@Param("search") String name, Pageable pageable);

    @Query(value = "select * from contract where customer_id = :id", nativeQuery = true)
    List<Contract> findByCustomerId(@Param("id") Integer id);
}
