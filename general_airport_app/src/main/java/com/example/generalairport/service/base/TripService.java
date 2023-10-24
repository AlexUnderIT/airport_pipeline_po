package com.example.generalairport.service.base;

import com.example.generalairport.entity.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TripService {
    Page<Trip> getAllPageable(Pageable pageable);

    Optional<Trip> findById(Long id);

    Trip getById(Long id);

    Trip save(Trip trip);

    void delete(Long id);
}
