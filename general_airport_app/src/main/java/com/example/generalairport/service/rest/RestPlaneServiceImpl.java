package com.example.generalairport.service.rest;

import com.example.generalairport.assembler.PlaneAssembler;
import com.example.generalairport.dto.CreatePlaneDto;
import com.example.generalairport.dto.PlaneDto;
import com.example.generalairport.entity.Plane;
import com.example.generalairport.service.base.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

@Service
public class RestPlaneServiceImpl implements RestPlaneService {
    private final PlaneAssembler planeAssembler;
    private final PlaneService planeService;

    @Autowired
    public RestPlaneServiceImpl(
            PlaneAssembler planeAssembler,
            @Qualifier("webhookPlaneService") PlaneService planeService
    ) {
        this.planeAssembler = planeAssembler;
        this.planeService = planeService;
    }

    @Override
    public PagedModel<PlaneDto> getAllPageable(Pageable pageable) {
        return planeAssembler.toPagedModel(planeService.getAllPageable(pageable));
    }

    @Override
    public PlaneDto getById(Long id) { return planeAssembler.toModel(planeService.getById(id)); }

    @Override
    public PlaneDto create(CreatePlaneDto createPlaneDto) {
        Plane plane = new Plane();
        plane.setName(createPlaneDto.getName());
        plane.setPlaneStatus(createPlaneDto.getPlaneStatus());
        plane.setAirlineName(createPlaneDto.getAirlineName());
        plane.setParkingName(createPlaneDto.getParkingName());
        plane.setSeatingCount(createPlaneDto.getSeatingCount());

        return planeAssembler.toModel(planeService.save(plane));
    }

    @Override
    public PlaneDto update(Long id, PlaneDto planeDto) {
        Plane updatedPlane = planeService.getById(id);
        updatedPlane.setName(planeDto.getName());
        updatedPlane.setPlaneStatus(planeDto.getPlaneStatus());
        updatedPlane.setAirlineName(planeDto.getAirlineName());
        updatedPlane.setSeatingCount(planeDto.getSeatingCount());
        return planeAssembler.toModel(planeService.save(updatedPlane));
    }

    @Override
    public void delete(Long id) {
        planeService.delete(id);
    }
}
