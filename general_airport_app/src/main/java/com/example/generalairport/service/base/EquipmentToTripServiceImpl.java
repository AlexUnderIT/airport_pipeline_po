package com.example.generalairport.service.base;

import com.example.generalairport.entity.EquipmentToTrip;
import com.example.generalairport.exception.EquipmentNotFoundException;
import com.example.generalairport.repository.EquipmentToTripRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipmentToTripServiceImpl implements EquipmentToTripService {
    private final EquipmentToTripRepository equipmentToTripRepository;

    public EquipmentToTripServiceImpl(EquipmentToTripRepository equipmentToTripRepository) {
        this.equipmentToTripRepository = equipmentToTripRepository;
    }

    @Override
    public Page<EquipmentToTrip> getAllPageable(Pageable pageable) { return equipmentToTripRepository.findAll(pageable); }

    @Override
    public Optional<EquipmentToTrip> findById(Long id) { return equipmentToTripRepository.findById(id); }

    @Override
    public EquipmentToTrip getById(Long id) { return findById(id).orElseThrow(() -> new EquipmentNotFoundException()); }

    @Override
    public EquipmentToTrip create(EquipmentToTrip equipmentToTrip) { return equipmentToTripRepository.save(equipmentToTrip); }

    @Override
    public void delete(Long id) { equipmentToTripRepository.deleteById(id); }
}
