package com.example.generalairport.assembler.dto;

import com.example.generalairport.dto.webhook.WebhookTripDto;
import com.example.generalairport.entity.Trip;
import org.springframework.stereotype.Component;

@Component
public class TripWebhookAssembler {

    public WebhookTripDto toWebhookModel(Trip trip){

        WebhookTripDto webhookTripDto = new WebhookTripDto();
        webhookTripDto.setId(trip.getId());
        webhookTripDto.setAirlineName(trip.getAirlineName());
        webhookTripDto.setTripNumber(trip.getTripNumber());
        webhookTripDto.setTripStatus(trip.getTripStatus());
        webhookTripDto.setArrivalTime(trip.getArrivalTime());
        webhookTripDto.setDestinationAirport(trip.getDestinationAirport());
        webhookTripDto.setDestinationCity(trip.getDestinationCity());
        webhookTripDto.setArrivalTime(trip.getArrivalTime());
        webhookTripDto.setDestinationCountry(trip.getDestinationCountry());
        webhookTripDto.setPlaneId(trip.getPlaneId());

        return webhookTripDto;
    }
}
