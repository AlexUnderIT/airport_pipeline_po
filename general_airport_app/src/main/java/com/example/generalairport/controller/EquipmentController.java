package com.example.generalairport.controller;

import com.example.generalairport.dto.CreateEquipmentDto;
import com.example.generalairport.dto.EquipmentDto;
import com.example.generalairport.service.rest.RestEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/equipment")
public class EquipmentController {
    private final RestEquipmentService restEquipmentService;

    @Autowired
    public EquipmentController(RestEquipmentService restEquipmentService) {
        this.restEquipmentService = restEquipmentService;
    }

    @GetMapping
    public PagedModel<EquipmentDto> getAllEquipment(
        @PageableDefault Pageable pageable
    ) {
        return restEquipmentService.getAllPageable(pageable);
    }

    @GetMapping("/tripId/{tripId}")
    public PagedModel<EquipmentDto> getAllEquipmentByTripId(
            @PathVariable("tripId") Long tripId,
            @PageableDefault Pageable pageable
    ) {
        return restEquipmentService.getAllPageableByTripId(tripId, pageable);
    }

    @GetMapping("{id}")
    public EquipmentDto getEquipment(
        @PathVariable("id") Long id
    ) {
        return restEquipmentService.getById(id);
    }

    @PostMapping()
    public EquipmentDto createEquipment(
        @RequestBody CreateEquipmentDto createEquipmentDto
    ) {
        return restEquipmentService.create(createEquipmentDto);
    }

    @PutMapping("{id}")
    public EquipmentDto updateEquipment(
            @PathVariable("id") Long id,
            @RequestBody EquipmentDto equipmentDto
    ) {
        return restEquipmentService.update(id, equipmentDto);
    }

    @DeleteMapping("{id}")
    public void deleteEquipment(
            @PathVariable("id") Long id
    ) {
        restEquipmentService.delete(id);
    }
}
