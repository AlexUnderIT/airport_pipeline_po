package com.example.generalairport.service.base;

import com.example.generalairport.entity.Equipment;
import com.example.generalairport.exception.EquipmentNotFoundException;
import com.example.generalairport.repository.EquipmentRepository;
import com.example.generalairport.repository.EquipmentToTripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    private final EquipmentRepository equipmentRepository;
    private final EquipmentToTripRepository equipmentToTripRepository;

    @Autowired
    public EquipmentServiceImpl(
            EquipmentRepository equipmentRepository,
            EquipmentToTripRepository equipmentToTripRepository
    ) {
        this.equipmentRepository = equipmentRepository;
        this.equipmentToTripRepository = equipmentToTripRepository;
    }

    @Override
    public Page<Equipment> getAllPageable(Pageable pageable) {
        return equipmentRepository.findAll(pageable);
    }

    @Override
    public Page<Equipment> getAllPageableByTripId(Long tripId, Pageable pageable) {
        return equipmentToTripRepository.findAllByTripId(tripId, pageable);
    }

    @Override
    public Optional<Equipment> findById(Long id) {
        return equipmentRepository.findById(id);
    }

    @Override
    public Equipment getById(Long id) {
        return findById(id).orElseThrow(() -> new EquipmentNotFoundException());
    }

    @Override
    public Equipment create(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @Override
    public void delete(Long id) { equipmentRepository.deleteById(id); }
}
