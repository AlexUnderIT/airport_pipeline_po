package com.example.generalairport.service.rest;

import com.example.generalairport.assembler.TicketDtoAssembler;
import com.example.generalairport.dto.TicketDto;
import com.example.generalairport.entity.Ticket;
import com.example.generalairport.service.base.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

@Service
public class RestTicketServiceImpl implements RestTicketService{
    private final TicketDtoAssembler ticketAssembler;
    private final TicketService ticketService;

    @Autowired
    public RestTicketServiceImpl(
            TicketDtoAssembler ticketAssembler,
            TicketService ticketService
    ) {
        this.ticketAssembler = ticketAssembler;
        this.ticketService = ticketService;
    }

    @Override
    public PagedModel<TicketDto> getAllPageable(Pageable pageable) {
        return ticketAssembler.toPagedModel(ticketService.getAllPageable(pageable));
    }

    @Override
    public TicketDto getById(Long id) {
        return ticketAssembler.toModel(ticketService.getById(id));
    }

    @Override
    public TicketDto update(Long id, TicketDto ticketDto) {
        Ticket updatedTicket = ticketService.getById(id);
        updatedTicket.setHasBaggage(ticketDto.getHasBaggage());
        updatedTicket.setHasFood(ticketDto.getHasFood());
        updatedTicket.setHasPets(ticketDto.getHasPets());
        updatedTicket.setSeatName(ticketDto.getSeatName());
        updatedTicket.setSeatClass(ticketDto.getSeatClass());
        updatedTicket.setTransferToPlainType(ticketDto.getTransferToPlainType());
        return ticketAssembler.toModel(ticketService.save(updatedTicket));
    }

    @Override
    public void delete(Long id) {
        ticketService.delete(id);
    }
}
