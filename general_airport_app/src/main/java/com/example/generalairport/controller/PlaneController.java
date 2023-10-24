package com.example.generalairport.controller;

import com.example.generalairport.dto.CreatePlaneDto;
import com.example.generalairport.dto.PlaneDto;
import com.example.generalairport.service.rest.RestPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/plane")
public class PlaneController {
    private final RestPlaneService restPlaneService;

    @Autowired
    public PlaneController(
        RestPlaneService restPlaneService
    ) {
        this.restPlaneService = restPlaneService;
    }

    @GetMapping
    public PagedModel<PlaneDto> getAllPlane(
        @PageableDefault Pageable pageable
    ) {
        return restPlaneService.getAllPageable(pageable);
    }

    @GetMapping("{id}")
    public PlaneDto getPlane(
        @PathVariable("id") Long id
    ) {
        return restPlaneService.getById(id);
    }

    @PostMapping()
    public PlaneDto createPlane(
        @RequestBody CreatePlaneDto createPlaneDto
    ) {
        return restPlaneService.create(createPlaneDto);
    }

    @PutMapping("{id}")
    public PlaneDto updatePlane(
            @PathVariable("id") Long id,
            @RequestBody PlaneDto planeDto
    ) {
        return restPlaneService.update(id, planeDto);
    }

    @DeleteMapping("{id}")
    public void deletePlane(
            @PathVariable("id") Long id
    ) {
        restPlaneService.delete(id);
    }
}
