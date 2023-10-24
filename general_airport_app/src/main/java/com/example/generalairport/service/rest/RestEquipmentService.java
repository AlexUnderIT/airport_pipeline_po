package com.example.generalairport.service.rest;

import com.example.generalairport.dto.CreateEquipmentDto;
import com.example.generalairport.dto.EquipmentDto;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

public interface RestEquipmentService {
    PagedModel<EquipmentDto> getAllPageable(Pageable pageable);

    PagedModel<EquipmentDto> getAllPageableByTripId(Long tripId, Pageable pageable);

    EquipmentDto getById(Long id);

    EquipmentDto create(CreateEquipmentDto createEquipmentDto);

    EquipmentDto update(Long id, EquipmentDto equipmentDto);

    void delete(Long id);
}
