package com.example.generalairport.service.rest;

import com.example.generalairport.dto.CreatePassengerDto;
import com.example.generalairport.dto.PassengerDto;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

public interface RestPassengerService {

    PagedModel<PassengerDto> getAllPageable(Pageable pageable);

    PassengerDto getById(Long id);

    PassengerDto create(CreatePassengerDto createPassengerDto);

    PassengerDto update(Long id, PassengerDto passengerDto);

    void delete(Long id);
}
