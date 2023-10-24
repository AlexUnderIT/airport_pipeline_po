package com.example.generalairport.service.rest;

import com.example.generalairport.assembler.EquipmentAssembler;
import com.example.generalairport.dto.CreateEquipmentDto;
import com.example.generalairport.dto.EquipmentDto;
import com.example.generalairport.entity.Equipment;
import com.example.generalairport.entity.EquipmentToTrip;
import com.example.generalairport.entity.Trip;
import com.example.generalairport.service.base.EquipmentService;
import com.example.generalairport.service.base.EquipmentToTripService;
import com.example.generalairport.service.base.TripService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

@Service
public class RestEquipmentServiceImpl implements RestEquipmentService {
    private final EquipmentAssembler equipmentAssembler;
    private final EquipmentService equipmentService;
    private final TripService tripService;
    private final EquipmentToTripService equipmentToTripService;

    public RestEquipmentServiceImpl(
            EquipmentAssembler equipmentAssembler,
            EquipmentService equipmentService,
            @Qualifier("tripServiceImpl") TripService tripService,
            EquipmentToTripService equipmentToTripService
    ) {
        this.equipmentAssembler = equipmentAssembler;
        this.equipmentService = equipmentService;
        this.tripService = tripService;
        this.equipmentToTripService = equipmentToTripService;
    }

    @Override
    public PagedModel<EquipmentDto> getAllPageable(Pageable pageable) {
        return equipmentAssembler.toPagedModel(equipmentService.getAllPageable(pageable));
    }

    @Override
    public PagedModel<EquipmentDto> getAllPageableByTripId(Long tripId, Pageable pageable) {
        return equipmentAssembler.toPagedModel(equipmentService.getAllPageableByTripId(tripId, pageable));
    }

    @Override
    public EquipmentDto getById(Long id) {
        return equipmentAssembler.toModel(equipmentService.getById(id));
    }

    @Override
    @Transactional
    public EquipmentDto create(CreateEquipmentDto createEquipmentDto) {
        Equipment equipment = new Equipment();
        equipment.setEquipmentType(createEquipmentDto.getEquipmentType());
        equipment.setModelName(createEquipmentDto.getModelName());
        equipment.setState(createEquipmentDto.getState());
        EquipmentDto equipmentDto = equipmentAssembler.toModel(equipmentService.create(equipment));

        Trip trip = tripService.getById(createEquipmentDto.getTripId());
        EquipmentToTrip equipmentToTrip = new EquipmentToTrip();
        equipmentToTrip.setEquipment(equipment);
        equipmentToTrip.setEquipmentId(equipmentDto.getId());
        equipmentToTrip.setTrip(trip);
        equipmentToTrip.setTripId(createEquipmentDto.getTripId());
        equipmentToTripService.create(equipmentToTrip);

        return equipmentDto;
    }

    @Override
    public EquipmentDto update(Long id, EquipmentDto equipmentDto) {
        Equipment updatedEquipment = equipmentService.getById(id);
        updatedEquipment.setEquipmentType(equipmentDto.getEquipmentType());
        updatedEquipment.setModelName(equipmentDto.getModelName());
        updatedEquipment.setState(equipmentDto.getState());
        return equipmentAssembler.toModel(equipmentService.create(updatedEquipment));
    }

    @Override
    public void delete(Long id) {
        equipmentService.delete(id);
    }
}
