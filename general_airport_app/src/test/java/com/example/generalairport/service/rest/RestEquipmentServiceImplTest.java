package com.example.generalairport.service.rest;

import com.example.generalairport.assembler.EquipmentAssembler;
import com.example.generalairport.dto.CreateEquipmentDto;
import com.example.generalairport.dto.EquipmentDto;
import com.example.generalairport.entity.*;
import com.example.generalairport.service.base.EquipmentService;
import com.example.generalairport.service.base.EquipmentToTripService;
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

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestEquipmentServiceImplTest {

    private Page<Equipment> equipmentPage;
    private Pageable pageable;
    private PagedModel<EquipmentDto> pagedModel;
    private Equipment testEquipment;
    private EquipmentDto testEquipmentDto;
    private CreateEquipmentDto testCreateEquipmentDto;

    @Mock
    private EquipmentAssembler equipmentAssembler;

    @Mock
    private TripService tripService;

    @Mock
    private EquipmentToTripService equipmentToTripService;

    @Mock
    private EquipmentService equipmentService;

    @InjectMocks
    private RestEquipmentServiceImpl service;

    @BeforeEach
    void beforeEachInitialization(){

        var size = 1;
        var from = 0;
        pageable = PageRequest.of(from / size, size);

        testEquipment = new Equipment();
        testEquipment.setEquipmentType(EquipmentType.BUS)
                .setState(2)
                .setModelName("Model")
                .setId(1L);

        testEquipmentDto = new EquipmentDto();
        testEquipmentDto.setEquipmentType(EquipmentType.BUS)
                .setState(2)
                .setModelName("Model")
                .setId(1L);

        testCreateEquipmentDto = new CreateEquipmentDto();
        testCreateEquipmentDto.setEquipmentType(EquipmentType.BUS)
                .setState(2)
                .setModelName("Model")
                .setTripId(1L);

        equipmentPage = new PageImpl<>(Collections.singletonList(new Equipment()));

        PagedModel.PageMetadata metadata = new PagedModel.PageMetadata(
                equipmentPage.getSize(),
                equipmentPage.getNumber(),
                equipmentPage.getTotalElements(),
                equipmentPage.getTotalPages());

        pagedModel= PagedModel.of(Collections.singletonList(new EquipmentDto()), metadata);
    }

    @Test
    void getAllPageable_returnValid() {
        when(equipmentService.getAllPageable(Mockito.any())).thenReturn(equipmentPage);
        when(equipmentAssembler.toPagedModel(equipmentPage)).thenReturn(pagedModel);

        var getAllTest = service.getAllPageable(Mockito.any());

        assertNotNull(getAllTest);
        assertEquals(pagedModel, getAllTest);
    }


    @Test
    void getAllPageableByTripId_returnValid() {
        var testTripId = 1L;
        when(equipmentService.getAllPageableByTripId(testTripId, pageable)).thenReturn(equipmentPage);
        when(equipmentAssembler.toPagedModel(equipmentPage)).thenReturn(pagedModel);

        var getAllTest = service.getAllPageableByTripId(1L, pageable);

        assertNotNull(getAllTest);
        assertEquals(pagedModel, getAllTest);
    }

    @Test
    void getById_returnValid() {
        var testId = 1L;
        when(equipmentService.getById(testId)).thenReturn(testEquipment);
        when(equipmentAssembler.toModel(testEquipment)).thenReturn(testEquipmentDto);

        var testGetById = service.getById(testId);

        assertNotNull(testGetById);
        assertEquals(testEquipmentDto, testGetById);
        assertEquals(testGetById.getId(), testId);
    }

    @Test
    void create_returnValid() {
        var testId = 1L;
        Trip testTrip = new Trip();
        testTrip.setTripStatus(TripStatus.PLANNED);

        EquipmentToTrip testEquipmentToTrip = new EquipmentToTrip();
        testEquipmentToTrip.setTrip(testTrip);

        when(equipmentService.create(Mockito.any())).thenReturn(testEquipment);
        when(equipmentAssembler.toModel(testEquipment)).thenReturn(testEquipmentDto);
        when(tripService.getById(testId)).thenReturn(testTrip);
        when(equipmentToTripService.create(Mockito.any())).thenReturn(testEquipmentToTrip);

        var createTest = service.create(testCreateEquipmentDto);

        assertNotNull(createTest);
        assertEquals(testCreateEquipmentDto.getEquipmentType(),createTest.getEquipmentType());
        verify(equipmentService, times(1)).create(any());
        verify(equipmentToTripService, times(1)).create(any());

    }

    @Test
    void update_returnValid(){
        var testId = 1L;
        Equipment testUpdateEquipment = new Equipment();
        testUpdateEquipment.setEquipmentType(EquipmentType.LADDER)
                .setState(5)
                .setModelName("Test")
                .setId(2L);

        EquipmentDto testUpdateEquipmentDto = new EquipmentDto();
        testUpdateEquipmentDto.setEquipmentType(EquipmentType.LADDER)
                .setState(5)
                .setModelName("Test")
                .setId(2L);

        EquipmentDto testUpdateEquipmentDtoClone = new EquipmentDto();
        testUpdateEquipmentDtoClone.setEquipmentType(EquipmentType.LADDER)
                .setState(5)
                .setModelName("Test")
                .setId(2L);

        when(equipmentService.getById(testId)).thenReturn(testEquipment);
        when(equipmentService.create(any())).thenReturn(testUpdateEquipment);
        when(equipmentAssembler.toModel(testUpdateEquipment)).thenReturn(testUpdateEquipmentDtoClone);

        var updateTestValid = service.update(testId, testUpdateEquipmentDto);

        assertNotNull(updateTestValid);
        assertEquals(testUpdateEquipmentDto.getModelName(), updateTestValid.getModelName());
        assertEquals(testUpdateEquipmentDto.getId(), updateTestValid.getId());
        assertEquals(testUpdateEquipmentDto.getState(), updateTestValid.getState());
        assertEquals(testUpdateEquipmentDto.getEquipmentType(), updateTestValid.getEquipmentType());
    }
}