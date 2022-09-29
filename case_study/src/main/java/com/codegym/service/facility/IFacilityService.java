package com.codegym.service.facility;

import com.codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    Page<Facility> findAll(Pageable pageable);

    void save(Facility facility);

    Optional<Facility> findById(int id);

    void remove(int id);

    Page<Facility> search(String name, Pageable pageInfo);

    List<Facility> findAll();
}
