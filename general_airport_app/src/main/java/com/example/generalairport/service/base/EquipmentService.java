package com.example.generalairport.service.base;

import com.example.generalairport.entity.Equipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EquipmentService {
    Page<Equipment> getAllPageable(Pageable pageable);

    Page<Equipment> getAllPageableByTripId(Long tripId, Pageable pageable);

    Optional<Equipment> findById(Long id);

    Equipment getById(Long id);

    Equipment create(Equipment equipment);

    void delete(Long id);
}
