package com.example.generalairport.assembler;

import com.example.generalairport.dto.PlaneDto;
import com.example.generalairport.entity.Plane;
import org.springframework.stereotype.Component;

@Component
public class PlaneAssembler extends AbstractDtoAssembler<Plane, PlaneDto>{
    @Override
    public PlaneDto toModel(Plane entity) {
        PlaneDto planeDto = new PlaneDto();
        planeDto.setId(entity.getId());
        planeDto.setName(entity.getName());
        planeDto.setPlaneStatus(entity.getPlaneStatus());
        planeDto.setAirlineName(entity.getAirlineName());
        planeDto.setSeatingCount(entity.getSeatingCount());

        return planeDto;
    }
}
