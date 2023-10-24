package com.example.generalairport.assembler;

import com.example.generalairport.dto.TripDto;
import com.example.generalairport.entity.Trip;
import org.springframework.stereotype.Component;

@Component
public class TripAssembler extends AbstractDtoAssembler<Trip, TripDto> {
    @Override
    public TripDto toModel(Trip entity) {
        TripDto tripDto = new TripDto();
        tripDto.setId(entity.getId());
        tripDto.setTripNumber(entity.getTripNumber());
        tripDto.setDestinationCity(entity.getDestinationCity());
        tripDto.setDestinationCountry(entity.getDestinationCountry());
        tripDto.setDestinationAirport(entity.getDestinationAirport());
        tripDto.setTripStatus(entity.getTripStatus());
        tripDto.setDepartureTime(entity.getDepartureTime());
        tripDto.setArrivalTime(entity.getArrivalTime());
        tripDto.setAirlineName(entity.getAirlineName());
        tripDto.setPlaneId(entity.getPlaneId());

        return tripDto;
    }
}
