package com.example.generalairport.service.rest;

import com.example.generalairport.assembler.PlaneAssembler;
import com.example.generalairport.dto.CreatePlaneDto;
import com.example.generalairport.dto.PlaneDto;
import com.example.generalairport.entity.Plane;
import com.example.generalairport.entity.PlaneStatus;
import com.example.generalairport.service.base.PlaneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestPlaneServiceImplTest {

    private Page<Plane> planePage;
    private PagedModel<PlaneDto> pagedModel;
    private Plane testPlane;
    private PlaneDto testPlaneDto;
    private CreatePlaneDto testCreatePlaneDto;

    @Mock
    private PlaneAssembler planeAssembler;

    @Mock
    private PlaneService planeService;

    @InjectMocks
    private RestPlaneServiceImpl service;

    @BeforeEach
    void createUsefulPlaneObjects(){
        testPlane = new Plane();
        testPlane
                .setPlaneStatus(PlaneStatus.LANDING)
                .setName("Airbus")
                .setSeatingCount(125)
                .setParkingName("NBK112")
                .setAirlineName("Aeroflot").
                setId(1L);

        testPlaneDto = new PlaneDto();
        testPlaneDto
                .setPlaneStatus(PlaneStatus.LANDING)
                .setName("Airbus")
                .setSeatingCount(125)
                .setAirlineName("Aeroflot")
                .setId(1L);

        testCreatePlaneDto = new CreatePlaneDto();
        testCreatePlaneDto
                .setPlaneStatus(PlaneStatus.LANDING)
                .setName("Airbus")
                .setSeatingCount(125)
                .setAirlineName("Aeroflot")
                .setParkingName("NBK112");

        planePage = new PageImpl<>(Collections.singletonList(new Plane()));

        PagedModel.PageMetadata metadata = new PagedModel.PageMetadata(
                planePage.getSize(),
                planePage.getNumber(),
                planePage.getTotalElements(),
                planePage.getTotalPages());

        pagedModel= PagedModel.of(Collections.singletonList(new PlaneDto()), metadata);
    }

    @Test
    void getAllPageable_returnValidResponse() {
        when(planeService.getAllPageable(Mockito.any())).thenReturn(planePage);
        when(planeAssembler.toPagedModel(planePage)).thenReturn(pagedModel);

        PagedModel<PlaneDto> testGetPageable = service.getAllPageable(Mockito.any());

        assertNotNull(testGetPageable);
        assertEquals(pagedModel, testGetPageable);
    }

    @Test
    void getById_returnValidPlane() {

        var testId = 1L;
        when(planeService.getById(testId)).thenReturn(testPlane);
        when(planeAssembler.toModel(testPlane)).thenReturn(testPlaneDto);

        PlaneDto responseDto = service.getById(testId);

        assertNotNull(responseDto);
        assertEquals(testPlaneDto.getName(),responseDto.getName());
        verify(planeService,times(1)).getById(Mockito.any());

    }

    @Test
    void create_returnValid() {
        when(planeService.save(Mockito.any())).thenReturn(testPlane);
        when(planeAssembler.toModel(Mockito.any())).thenReturn(testPlaneDto);

        PlaneDto createPlaneDto = service.create(testCreatePlaneDto);

        assertNotNull(createPlaneDto);
        assertEquals(testPlaneDto, createPlaneDto);
        verify(planeService, times(1)).save(any());
    }

    @Test
    void update_returnValidResponse() {
        var testId = 1L;

        PlaneDto updatePlaneDto = new PlaneDto();
        updatePlaneDto
                .setPlaneStatus(PlaneStatus.CLEANING)
                .setName("Boeing")
                .setSeatingCount(330)
                .setAirlineName("KutBH");

        when(planeService.getById(testId)).thenReturn(testPlane);
        when(planeService.save(any())).thenReturn(testPlane);
        when(planeAssembler.toModel(any())).thenReturn(updatePlaneDto);

        PlaneDto testUpdatePlaneDto = service.update(testId, updatePlaneDto);

        assertNotNull(testUpdatePlaneDto);
        assertEquals(updatePlaneDto, testUpdatePlaneDto);
        verify(planeService, times(1)).save(any());
    }
}