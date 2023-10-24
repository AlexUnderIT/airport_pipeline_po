package com.example.generalairport.service.webhook;

import com.example.generalairport.assembler.dto.TripWebhookAssembler;
import com.example.generalairport.entity.Trip;
import com.example.generalairport.service.AirportEvent;
import com.example.generalairport.service.base.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WebhookTripService implements TripService {

    private final TripService tripService;
    private final WebhookGateway webhookGateway;
    private final TripWebhookAssembler tripWebhookAssembler;

    @Autowired
    public WebhookTripService(
        @Qualifier("tripServiceImpl") TripService tripService,
        WebhookGateway webhookGateway,
        TripWebhookAssembler tripWebhookAssembler
    ) {
        this.tripService = tripService;
        this.webhookGateway = webhookGateway;
        this.tripWebhookAssembler = tripWebhookAssembler;
    }


    @Override
    public Page<Trip> getAllPageable(Pageable pageable) {
        return tripService.getAllPageable(pageable);
    }

    @Override
    public Optional<Trip> findById(Long id) {
        return tripService.findById(id);
    }

    @Override
    public Trip getById(Long id) {
        return tripService.getById(id);
    }

    @Override
    public Trip save(Trip trip) {
        boolean isNew = trip.isNew();
        Trip createdTrip = tripService.save(trip);

        webhookGateway.sendWebhook(isNew? AirportEvent.TRIP_CREATE : AirportEvent.TRIP_UPDATE, tripWebhookAssembler.toWebhookModel(trip));

        return createdTrip;
    }

    @Override
    public void delete(Long id) {
        tripService.delete(id);
    }
}
