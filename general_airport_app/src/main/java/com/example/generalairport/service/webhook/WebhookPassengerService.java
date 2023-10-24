package com.example.generalairport.service.webhook;

import com.example.generalairport.assembler.dto.PassengerWebhookAssembler;
import com.example.generalairport.dto.webhook.WebhookPassengerDto;
import com.example.generalairport.entity.Passenger;
import com.example.generalairport.entity.Ticket;
import com.example.generalairport.service.AirportEvent;
import com.example.generalairport.service.base.PassengerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WebhookPassengerService implements PassengerService {

    private final PassengerService passengerService;
    private final WebhookGateway webhookGateway;
    private final PassengerWebhookAssembler passengerWebhookAssembler;

    public WebhookPassengerService(
        @Qualifier("passengerServiceImpl") PassengerService passengerService,
        WebhookGateway webhookGateway,
        PassengerWebhookAssembler passengerWebhookAssembler
    ) {
        this.passengerService = passengerService;
        this.webhookGateway = webhookGateway;
        this.passengerWebhookAssembler = passengerWebhookAssembler;
    }

    @Override
    public Page<Passenger> getAllPageable(Pageable pageable) {
        return passengerService.getAllPageable(pageable);
    }

    @Override
    public Optional<Passenger> findById(Long id) {
        return passengerService.findById(id);
    }

    @Override
    public Passenger getById(Long id) {
        return passengerService.getById(id);
    }

    @Override
    public Passenger create(Passenger passenger, Ticket ticket) {
        Passenger persistentPassenger = passengerService.create(passenger, ticket);
        WebhookPassengerDto webhookPassengerDto = passengerWebhookAssembler.toWebhookModel(passenger);

        //TODO по-хорошему отправлять асинхронно
        webhookGateway.sendWebhook(AirportEvent.PASSENGER_CREATE, webhookPassengerDto);

        return persistentPassenger;
    }

    @Override
    public Passenger update(Passenger passenger) {
        return passengerService.update(passenger);
    }

    @Override
    public void delete(Long id) {
        passengerService.delete(id);
    }
}
