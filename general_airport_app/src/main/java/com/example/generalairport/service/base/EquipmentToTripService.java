package com.example.generalairport.service.base;

import com.example.generalairport.entity.EquipmentToTrip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EquipmentToTripService {
    Page<EquipmentToTrip> getAllPageable(Pageable pageable);

    Optional<EquipmentToTrip> findById(Long id);

    EquipmentToTrip getById(Long id);

    EquipmentToTrip create(EquipmentToTrip equipmentToTrip);

    void delete(Long id);
}
