package com.example.generalairport.service.rest;

import com.example.generalairport.assembler.PassengerAssembler;
import com.example.generalairport.dto.CreatePassengerDto;
import com.example.generalairport.dto.PassengerDto;
import com.example.generalairport.dto.TripDto;
import com.example.generalairport.entity.*;
import com.example.generalairport.service.base.NationalityService;
import com.example.generalairport.service.base.PassengerService;
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

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestPassengerServiceImplTest {

    private Page<Passenger> passengerPage;
    private PagedModel<PassengerDto> pagedModel;
    private Passenger testPassenger;
    private PassengerDto testPassengerDto;
    private CreatePassengerDto testCreatePassengerDto;

    @Mock
    private PassengerAssembler passengerAssembler;

    @Mock
    private PassengerService passengerService;

    @Mock
    private NationalityService nationalityService;

    @InjectMocks
    RestPassengerServiceImpl service;

    @BeforeEach
    void initializeUseful(){
        testPassenger = new Passenger();
        testPassenger.setId(1L);
        testPassenger.setName("Ivan")
                .setSurname("Petrov")
                .setBirthday(LocalDate.of(2002,11,16))
                .setGender(Gender.MALE)
                .setPassportInfo("some passport info")
                .setPhoneNumber("88005553535")
                .setEmail("petrov@mail.ru")
                .setSuspicionStatus(SuspicionStatus.NONE);

        testPassengerDto = new PassengerDto();
        testPassengerDto.setId(1L);
        testPassengerDto.setName("Ivan")
                .setSurname("Petrov")
                .setBirthday(LocalDate.of(2002,11,16))
                .setGender(Gender.MALE)
                .setPassportInfo("some passport info")
                .setPhoneNumber("88005553535")
                .setEmail("petrov@mail.ru")
                .setSuspicionStatus(SuspicionStatus.NONE);

        testCreatePassengerDto = new CreatePassengerDto();
        testCreatePassengerDto.setName("Ivan")
                .setSurname("Petrov")
                .setBirthday(LocalDate.of(2002,11,16))
                .setGender(Gender.MALE)
                .setPassportInfo("some passport info")
                .setPhoneNumber("88005553535")
                .setEmail("petrov@mail.ru")
                .setHasBaggage(false)
                .setHasFood(false)
                .setHasPets(false)
                .setHasWeapon(false)
                .setHasDrugs(false)
                .setDangerousElectronics(false)
                .setTripId(1L)
                .setHandicapped(false)
                .setSeatName("BBK12")
                .setSeatClass("BUSINESS")
                .setTransferToPlain(TransferToPlainType.FOOT);

        passengerPage = new PageImpl<>(Collections.singletonList(new Passenger()));

        PagedModel.PageMetadata metadata = new PagedModel.PageMetadata(
                passengerPage.getSize(),
                passengerPage.getNumber(),
                passengerPage.getTotalElements(),
                passengerPage.getTotalPages());

        pagedModel= PagedModel.of(Collections.singletonList(new PassengerDto()), metadata);
    }

    @Test
    void getAllPageable_returnValid() {
        when(passengerService.getAllPageable(any())).thenReturn(passengerPage);
        when(passengerAssembler.toPagedModel(passengerPage)).thenReturn(pagedModel);

        var pageableReturn = service.getAllPageable(any());

        assertNotNull(pageableReturn);
        assertEquals(pagedModel, pageableReturn);
    }

    @Test
    void getById_returnValidResponse() {
        var testId = 1L;
        when(passengerService.getById(testId)).thenReturn(testPassenger);
        when(passengerAssembler.toModel(testPassenger)).thenReturn(testPassengerDto);

        var getByIdTest = service.getById(testId);

        assertNotNull(getByIdTest);
        assertEquals(testPassenger.getId(),getByIdTest.getId());
        assertEquals(testPassenger.getEmail(), getByIdTest.getEmail());
    }

    @Test
    void create_returnValid() {
        when(nationalityService.getFirstIgnoreCase(any())).thenReturn(new Nationality());
        when(passengerService.create(Mockito.any(), Mockito.any())).thenReturn(testPassenger);
        when(passengerAssembler.toModel(testPassenger)).thenReturn(testPassengerDto);

        var createTest = service.create(testCreatePassengerDto);

        assertNotNull(createTest);
        assertEquals(testPassengerDto,createTest);
        verify(passengerService, times(1)).create(any(), any());
    }

    @Test
    void update_returnValid() {
        var testId = 1L;
        when(nationalityService.getFirstIgnoreCase(any())).thenReturn(new Nationality());
        when(passengerService.getById(any())).thenReturn(testPassenger);
        when(passengerService.update(any())).thenReturn(testPassenger);
        when(passengerAssembler.toModel(testPassenger)).thenReturn(testPassengerDto);

        var testUpdate = service.update(testId, testPassengerDto);

        assertNotNull(testUpdate);
        assertEquals(testPassengerDto, testUpdate);
        verify(passengerService, times(1)).update(any());




    }
}