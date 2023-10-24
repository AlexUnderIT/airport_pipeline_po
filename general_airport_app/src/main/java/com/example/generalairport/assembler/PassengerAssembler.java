package com.example.generalairport.assembler;

import com.example.generalairport.dto.PassengerDto;
import com.example.generalairport.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PassengerAssembler extends AbstractDtoAssembler<Passenger, PassengerDto> {
    private final TicketDtoAssembler ticketDtoAssembler;

    @Autowired
    public PassengerAssembler(TicketDtoAssembler ticketDtoAssembler) {
        this.ticketDtoAssembler = ticketDtoAssembler;
    }

    @Override
    public PassengerDto toModel(Passenger entity) {
        PassengerDto passengerDto = new PassengerDto();
        passengerDto.setBirthday(entity.getBirthday());
        passengerDto.setEmail(entity.getEmail());
        passengerDto.setId(entity.getId());
        passengerDto.setNationality(entity.getNationality().getNationality());
        passengerDto.setPhoneNumber(entity.getPhoneNumber());
        passengerDto.setGender(entity.getGender());
        passengerDto.setPassportInfo(entity.getPassportInfo());
        passengerDto.setSurname(entity.getSurname());
        passengerDto.setName(entity.getName());
        passengerDto.setSuspicionStatus(entity.getSuspicionStatus());

        passengerDto.setTicket(ticketDtoAssembler.toModel(entity.getTicket()));

        return passengerDto;
    }
}
