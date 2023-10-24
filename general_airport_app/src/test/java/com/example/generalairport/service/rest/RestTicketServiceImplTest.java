package com.example.generalairport.service.rest;

import com.example.generalairport.assembler.TicketDtoAssembler;
import com.example.generalairport.dto.TicketDto;
import com.example.generalairport.dto.TripDto;
import com.example.generalairport.entity.Passenger;
import com.example.generalairport.entity.Ticket;
import com.example.generalairport.entity.TransferToPlainType;
import com.example.generalairport.entity.Trip;
import com.example.generalairport.service.base.TicketService;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestTicketServiceImplTest {

    private Page<Ticket> ticketPage;
    private PagedModel<TicketDto> ticketPagedModel;
    private Ticket testTicket;
    private TicketDto testTicketDto;

    @Mock
    private TicketDtoAssembler ticketAssembler;

    @Mock
    private TicketService ticketService;

    @InjectMocks
    private RestTicketServiceImpl service;

    @BeforeEach
    void createUsefulObjects(){

        testTicket = new Ticket();
        testTicket.setPassenger(new Passenger())
                .setHasBaggage(true)
                .setHasFood(true)
                .setHasPets(true)
                .setTrip(new Trip())
                .setSeatName("M792")
                .setSeatClass("BUSINESS")
                .setHasGabBaggage(true)
                .setHandicapped(true)
                .setPassengerId(1L)
                .setTransferToPlainType(TransferToPlainType.BUS);

        testTicketDto = new TicketDto();
        testTicketDto.setId(1L)
                .setHasBaggage(true)
                .setHasFood(true)
                .setHasPets(true)
                .setSeatName("M792")
                .setSeatClass("BUSINESS")
                .setTransferToPlainType(TransferToPlainType.BUS);

        ticketPage = new PageImpl<>(Collections.singletonList(new Ticket()));

        PagedModel.PageMetadata metadata = new PagedModel.PageMetadata(
                ticketPage.getSize(),
                ticketPage.getNumber(),
                ticketPage.getTotalElements(),
                ticketPage.getTotalPages());

        ticketPagedModel= PagedModel.of(Collections.singletonList(new TicketDto()), metadata);
    }

    @Test
    void getAllPageable_returnValidCapacityOfTickets(){
        when(ticketService.getAllPageable(Mockito.any())).thenReturn(ticketPage);
        when(ticketAssembler.toPagedModel(Mockito.any())).thenReturn(ticketPagedModel);

        PagedModel<TicketDto> ticketPagedModelTest = service.getAllPageable(Mockito.any());

        assertNotNull(ticketPagedModelTest);
        assertEquals(ticketPagedModel, ticketPagedModelTest);
    }

    @Test
    void getById_returnValidTicket(){
        var testId = 1L;

        when(ticketService.getById(Mockito.any())).thenReturn(testTicket);
        when(ticketAssembler.toModel(Mockito.any())).thenReturn(testTicketDto);

        TicketDto newTestDto = service.getById(testId);

        assertNotNull(newTestDto);
        assertEquals(testId, newTestDto.getId());
    }

    @Test
    void update_returnUpdatedTicket(){

        Ticket updateTestTicket = new Ticket();
        TicketDto updateTicketDtoTest = new TicketDto();
        updateTicketDtoTest.setId(12L)
                .setHasBaggage(true)
                .setHasFood(false)
                .setHasPets(true)
                .setSeatName("H82")
                .setSeatClass("ECONOMY")
                .setTransferToPlainType(TransferToPlainType.TELEBRIDGE);

        var testId = 12L;

        when(ticketService.getById(testId)).thenReturn(updateTestTicket);
        when(ticketService.save(Mockito.any())).thenReturn(updateTestTicket);
        when(ticketAssembler.toModel(updateTestTicket)).thenReturn(updateTicketDtoTest);

        TicketDto updateTestDto = service.update(testId,updateTicketDtoTest);


        assertNotNull(updateTestDto);
        assertNotEquals(testTicketDto, updateTicketDtoTest);
        verify(ticketService, times(1)).save(Mockito.any());

    }

}