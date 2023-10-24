package com.example.generalairport.service.rest;

import com.example.generalairport.assembler.TripAssembler;
import com.example.generalairport.dto.CreateTripDto;
import com.example.generalairport.dto.TripDto;
import com.example.generalairport.entity.Plane;
import com.example.generalairport.entity.Trip;
import com.example.generalairport.entity.TripStatus;
import com.example.generalairport.service.base.PlaneService;
import com.example.generalairport.service.base.TripService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestTripServiceImplTest {

    private Page<Trip> trips;
    private Pageable pageable;
    private PagedModel<TripDto> pagedModel;
    private Trip testTrip;
    private TripDto testTripDto;
    private CreateTripDto testCreateTripDto;

    @Mock
    private TripAssembler tripAssembler;

    @Mock
    private TripService tripService;

    @Mock
    private PlaneService planeService;

    @InjectMocks
    private RestTripServiceImpl service;

    @BeforeEach
    void getTrips(){

        var size = 1;
        var from = 0;
        pageable = PageRequest.of(from / size, size);


        testTrip = new Trip();
        testTrip.setId(1L);
        testTrip.setTripNumber("NB123");
        testTrip.setDestinationCity("Moscow");
        testTrip.setDestinationCountry("Russia");
        testTrip.setDestinationAirport("VKO");
        testTrip.setTripStatus(TripStatus.PLANNED);
        testTrip.setDepartureTime(ZonedDateTime.now());
        testTrip.setArrivalTime(ZonedDateTime.now());
        testTrip.setAirlineName("Aeroflot");
        testTrip.setPlaneId(1L);
        testTrip.setPlane(Mockito.any());

        testTripDto = new TripDto();
        testTripDto.setId(1L);
        testTripDto.setTripNumber("NB123");
        testTripDto.setDestinationCity("Moscow");
        testTripDto.setDestinationCountry("Russia");
        testTripDto.setDestinationAirport("VKO");
        testTripDto.setTripStatus(TripStatus.PLANNED);
        testTripDto.setDepartureTime(ZonedDateTime.now());
        testTripDto.setArrivalTime(ZonedDateTime.now());
        testTripDto.setAirlineName("Aeroflot");
        testTripDto.setPlaneId(1L);

        testCreateTripDto = new CreateTripDto();
        testCreateTripDto.setTripNumber("NB123");
        testCreateTripDto.setDestinationCity("Moscow");
        testCreateTripDto.setDestinationCountry("Russia");
        testCreateTripDto.setDestinationAirport("VKO");
        testCreateTripDto.setTripStatus(TripStatus.PLANNED);
        testCreateTripDto.setDepartureTime(ZonedDateTime.now());
        testCreateTripDto.setArrivalTime(ZonedDateTime.now());
        testCreateTripDto.setAirlineName("Aeroflot");
        testCreateTripDto.setPlaneId(1L);

        trips = new PageImpl<>(Collections.singletonList(new Trip()));

        PagedModel.PageMetadata metadata = new PagedModel.PageMetadata(
                trips.getSize(),
                trips.getNumber(),
                trips.getTotalElements(),
                trips.getTotalPages());

        pagedModel= PagedModel.of(Collections.singletonList(new TripDto()), metadata);
    }

    @Test
    void getAllPageable_returnValid(){

        when(tripService.getAllPageable(pageable)).thenReturn(trips);
        when(tripAssembler.toPagedModel(trips)).thenReturn(pagedModel);

        PagedModel<TripDto> tryingPaged = service.getAllPageable(pageable);

        assertNotNull(tryingPaged);
        assertEquals(pagedModel, tryingPaged);
    }

    @Test
    void getById_returnRightTrip(){

        var tripIdgiven = 1L;

        when(tripService.getById(tripIdgiven)).thenReturn(Optional.of(testTrip).get());
        when(tripAssembler.toModel(Optional.of(testTrip).get())).thenReturn(testTripDto);

        TripDto rightTrip = service.getById(tripIdgiven);

        assertNotNull(rightTrip);
        assertEquals(tripIdgiven, testTrip.getId());
    }

    @Test
    void save_returnValid(){

        when(tripService.save(testTrip)).thenReturn(testTrip);
        when(tripAssembler.toModel(testTrip)).thenReturn(testTripDto);
        when(planeService.getById(testCreateTripDto.getPlaneId())).thenReturn(new Plane());

        TripDto rightTrip = service.save(testCreateTripDto);

        assertNotNull(rightTrip);
        assertEquals(rightTrip, testTripDto);

        verify(tripService, times(1)).save(Mockito.any());
    }

    @Test
    void update_returnValid(){

        Long givenId = 2L;

        Trip updateTestTrip = new Trip();

        TripDto newTripDto = new TripDto();
        newTripDto
                .setId(2L)
                .setTripNumber("NB123")
                .setDestinationCity("New York")
                .setDestinationCountry("USA")
                .setDestinationAirport("NY")
                .setTripStatus(TripStatus.COMPLETED)
                .setDepartureTime(ZonedDateTime.now())
                .setArrivalTime(ZonedDateTime.now())
                .setAirlineName("US Airlines")
                .setPlaneId(2L);

        when(tripService.getById(givenId)).thenReturn(updateTestTrip);
        when(tripService.save(updateTestTrip)).thenReturn(updateTestTrip);
        when(tripAssembler.toModel(updateTestTrip)).thenReturn(newTripDto);

        TripDto testUpdateTripDto = service.update(givenId, newTripDto);

        assertNotNull(testTripDto);
        assertNotEquals(testTripDto, testUpdateTripDto);
        assertEquals("NB123",testUpdateTripDto.getTripNumber());
        assertEquals("New York", testUpdateTripDto.getDestinationCity());
        assertEquals("USA", testUpdateTripDto.getDestinationCountry());
        assertEquals(TripStatus.COMPLETED, testUpdateTripDto.getTripStatus());
        assertEquals("US Airlines", testUpdateTripDto.getAirlineName());

        verify(tripService, times(1)).save(Mockito.any());
    }
}