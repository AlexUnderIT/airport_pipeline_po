package com.example.generalairport.service.rest;

import com.example.generalairport.assembler.TripAssembler;
import com.example.generalairport.dto.CreateTripDto;
import com.example.generalairport.dto.TripDto;
import com.example.generalairport.entity.Plane;
import com.example.generalairport.entity.Trip;
import com.example.generalairport.service.base.PlaneService;
import com.example.generalairport.service.base.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

@Service
public class RestTripServiceImpl implements RestTripService {
    private final TripAssembler tripAssembler;
    private final TripService tripService;
    private final PlaneService planeService;

    @Autowired
    public RestTripServiceImpl(
        TripAssembler tripAssembler,
        @Qualifier("webhookTripService")TripService tripService,
        @Qualifier("planeServiceImpl") PlaneService planeService
    ) {
        this.tripAssembler = tripAssembler;
        this.tripService = tripService;
        this.planeService = planeService;
    }

    @Override
    public PagedModel<TripDto> getAllPageable(Pageable pageable) {
        return tripAssembler.toPagedModel(tripService.getAllPageable(pageable));
    }

    @Override
    public TripDto getById(Long id) {
        return tripAssembler.toModel(tripService.getById(id));
    }

    @Override
    public TripDto save(CreateTripDto createTripDto) {
        Trip trip = new Trip();
        trip.setTripNumber(createTripDto.getTripNumber());
        trip.setDestinationCity(createTripDto.getDestinationCity());
        trip.setDestinationCountry(createTripDto.getDestinationCountry());
        trip.setDestinationAirport(createTripDto.getDestinationAirport());
        trip.setTripStatus(createTripDto.getTripStatus());
        trip.setDepartureTime(createTripDto.getDepartureTime());
        trip.setArrivalTime(createTripDto.getArrivalTime());
        trip.setAirlineName(createTripDto.getAirlineName());
        Plane plane = planeService.getById(createTripDto.getPlaneId());
        trip.setPlaneId(plane.getId());
        trip.setPlane(plane);

        return tripAssembler.toModel(tripService.save(trip));
    }

    @Override
    public TripDto update(Long id, TripDto tripDto) {
        Trip updatedTrip = tripService.getById(id);
        updatedTrip.setTripNumber(tripDto.getTripNumber());
        updatedTrip.setDestinationCity(tripDto.getDestinationCity());
        updatedTrip.setDestinationCountry(tripDto.getDestinationCountry());
        updatedTrip.setDestinationAirport(tripDto.getDestinationAirport());
        updatedTrip.setTripStatus(tripDto.getTripStatus());
        updatedTrip.setDepartureTime(tripDto.getDepartureTime());
        updatedTrip.setArrivalTime(tripDto.getArrivalTime());
        updatedTrip.setAirlineName(tripDto.getAirlineName());
        updatedTrip.setPlaneId(tripDto.getPlaneId());
        return tripAssembler.toModel(tripService.save(updatedTrip));
    }

    @Override
    public void delete(Long id) {
        tripService.delete(id);
    }
}
