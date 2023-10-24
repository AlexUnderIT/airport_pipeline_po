package com.example.generalairport.repository;

import com.example.generalairport.entity.Equipment;
import com.example.generalairport.entity.EquipmentToTrip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EquipmentToTripRepository extends JpaRepository<EquipmentToTrip, Long> {
    @Query(value = "SELECT e.* FROM equipment e " +
            "JOIN equipment_to_trip et ON e.id = et.equipment_id " +
            "WHERE et.trip_id = :tripId",
            countQuery = "SELECT COUNT(*) FROM equipment e " +
                    "JOIN equipment_to_trip et ON e.id = et.equipment_id " +
                    "WHERE et.trip_id = :tripId",
            nativeQuery = true)
    Page<Equipment> findAllByTripId(@Param("tripId") Long tripId, Pageable pageable);
}
