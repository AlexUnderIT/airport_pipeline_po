package com.example.generalairport.controller;

import com.example.generalairport.dto.CreatePassengerDto;
import com.example.generalairport.dto.PassengerDto;
import com.example.generalairport.service.rest.RestPassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/passenger")
public class PassengerController {
    private final RestPassengerService restPassengerService;

    @Autowired
    public PassengerController(
        RestPassengerService restPassengerService
    ) {
        this.restPassengerService = restPassengerService;
    }

    @GetMapping
    public PagedModel<PassengerDto> getAllPassenger(
        @PageableDefault Pageable pageable
    ) {
        return restPassengerService.getAllPageable(pageable);
    }

    @GetMapping("{id}")
    public PassengerDto getPassenger(
        @PathVariable("id") Long id
    ) {
        return restPassengerService.getById(id);
    }


    @PostMapping()
    public PassengerDto createPassenger(
        @RequestBody CreatePassengerDto createPassengerDto
    ) {
        return restPassengerService.create(createPassengerDto);
    }

    @PutMapping("{id}")
    public PassengerDto updatePassenger(
            @PathVariable("id") Long id,
            @RequestBody PassengerDto passengerDto
    ) {
        return restPassengerService.update(id, passengerDto);
    }

    @DeleteMapping("{id}")
    public void deletePassenger(
            @PathVariable("id") Long id
    ) {
        restPassengerService.delete(id);
    }
}
