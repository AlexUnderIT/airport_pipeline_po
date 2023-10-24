package com.example.generalairport.controller;

import com.example.generalairport.dto.CreateTripDto;
import com.example.generalairport.dto.TripDto;
import com.example.generalairport.service.rest.RestTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/trip")
public class TripController {
    private final RestTripService restTripService;

    @Autowired
    public TripController(
        RestTripService restTripService
    ) {
        this.restTripService = restTripService;
    }

    @GetMapping
    public PagedModel<TripDto> getAllTrip(
        @PageableDefault Pageable pageable
    ) {
        return restTripService.getAllPageable(pageable);
    }

    @GetMapping("{id}")
    public TripDto getTrip(
        @PathVariable("id") Long id
    ) {
        return restTripService.getById(id);
    }

    @PostMapping()
    public TripDto createTrip(
        @RequestBody CreateTripDto createTripDto
    ) {
        return restTripService.save(createTripDto);
    }

    @PutMapping("{id}")
    public TripDto updateTrip(
            @PathVariable("id") Long id,
            @RequestBody TripDto tripDto
    ) {
        return restTripService.update(id, tripDto);
    }

    @DeleteMapping("{id}")
    public void deleteTrip(
            @PathVariable("id") Long id
    ) {
        restTripService.delete(id);
    }
}

