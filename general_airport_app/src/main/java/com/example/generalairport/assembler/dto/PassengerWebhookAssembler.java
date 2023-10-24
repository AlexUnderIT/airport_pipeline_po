package com.example.generalairport.assembler.dto;

import com.example.generalairport.dto.webhook.WebhookPassengerDto;
import com.example.generalairport.entity.Nationality;
import com.example.generalairport.entity.Passenger;
import com.example.generalairport.entity.Ticket;
import org.springframework.stereotype.Component;

@Component
public class PassengerWebhookAssembler {


    public WebhookPassengerDto toWebhookModel(Passenger passenger){
        WebhookPassengerDto webhookPassengerDto = new WebhookPassengerDto();
        webhookPassengerDto.setId(passenger.getId());
        webhookPassengerDto.setGender(passenger.getGender());
        webhookPassengerDto.setName(passenger.getName());
        webhookPassengerDto.setBirthday(passenger.getBirthday());
        webhookPassengerDto.setEmail(passenger.getEmail());
        webhookPassengerDto.setSurname(passenger.getSurname());
        webhookPassengerDto.setPassportInfo(passenger.getPassportInfo());
        webhookPassengerDto.setPhoneNumber(passenger.getPhoneNumber());
        webhookPassengerDto.setSuspicionStatus(passenger.getSuspicionStatus());
        Nationality nationality = passenger.getNationality();
        webhookPassengerDto.setNationality(nationality.getNationality());
        Ticket ticket = passenger.getTicket();

        webhookPassengerDto.setHasBaggage(ticket.getHasBaggage());
        webhookPassengerDto.setHasFood(ticket.getHasFood());
        webhookPassengerDto.setHasPets(ticket.getHasPets());
        webhookPassengerDto.setTripId(ticket.getTripId());
        webhookPassengerDto.setHandicapped(ticket.getHandicapped());
        webhookPassengerDto.setSeatClass(ticket.getSeatClass());
        webhookPassengerDto.setSeatName(ticket.getSeatName());

        webhookPassengerDto.setTransferToPlainType(ticket.getTransferToPlainType());

        return webhookPassengerDto;
    }
}
