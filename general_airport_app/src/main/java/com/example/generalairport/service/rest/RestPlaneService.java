package com.example.generalairport.service.rest;

import com.example.generalairport.dto.CreatePlaneDto;
import com.example.generalairport.dto.PlaneDto;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

public interface RestPlaneService {
    PagedModel<PlaneDto> getAllPageable(Pageable pageable);

    PlaneDto getById(Long id);

    PlaneDto create(CreatePlaneDto createPlaneDto);

    PlaneDto update(Long id, PlaneDto planeDto);

    void delete(Long id);
}
