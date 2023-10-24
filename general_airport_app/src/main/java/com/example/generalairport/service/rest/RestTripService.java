package com.example.generalairport.service.rest;

import com.example.generalairport.dto.CreateTripDto;
import com.example.generalairport.dto.TripDto;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

public interface RestTripService {
    PagedModel<TripDto> getAllPageable(Pageable pageable);

    TripDto getById(Long id);

    TripDto save(CreateTripDto createTripDto);

    TripDto update(Long id, TripDto tripDto);

    void delete(Long id);
}
