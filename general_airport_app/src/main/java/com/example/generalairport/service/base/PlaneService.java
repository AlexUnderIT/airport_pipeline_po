package com.example.generalairport.service.base;

import com.example.generalairport.entity.Plane;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PlaneService {
    Page<Plane> getAllPageable(Pageable pageable);

    Optional<Plane> findById(Long id);

    Plane getById(Long id);

    Plane save(Plane plane);

    void delete(Long id);
}
