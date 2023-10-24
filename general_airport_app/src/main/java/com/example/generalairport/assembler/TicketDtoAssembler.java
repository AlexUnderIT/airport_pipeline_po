package com.example.generalairport.assembler;

import com.example.generalairport.dto.TicketDto;
import com.example.generalairport.entity.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketDtoAssembler extends AbstractDtoAssembler<Ticket, TicketDto> {

    @Override
    public TicketDto toModel(Ticket entity) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId(entity.getId());
        ticketDto.setHasBaggage(entity.getHasBaggage());
        ticketDto.setHasPets(entity.getHasPets());
        ticketDto.setHasFood(entity.getHasFood());
        ticketDto.setTransferToPlainType(entity.getTransferToPlainType());
        ticketDto.setSeatName(entity.getSeatName());
        ticketDto.setSeatClass(entity.getSeatClass());
        return ticketDto;
    }

}
