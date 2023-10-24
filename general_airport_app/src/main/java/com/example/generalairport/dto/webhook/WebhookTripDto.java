package com.example.generalairport.dto.webhook;

import com.example.generalairport.entity.TripStatus;

import java.time.ZonedDateTime;

public class WebhookTripDto extends AbstractWebhookDto{

    private String tripNumber;
    private String destinationCity;
    private String destinationCountry;
    private String destinationAirport;
    private TripStatus tripStatus;
    private ZonedDateTime departureTime;
    private ZonedDateTime arrivalTime;
    private String airlineName;
    private Long planeId;

    public String getTripNumber() {
        return tripNumber;
    }

    public WebhookTripDto setTripNumber(String tripNumber) {
        this.tripNumber = tripNumber;
        return this;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public WebhookTripDto setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
        return this;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public WebhookTripDto setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
        return this;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public WebhookTripDto setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
        return this;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public WebhookTripDto setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
        return this;
    }

    public ZonedDateTime getDepartureTime() {
        return departureTime;
    }

    public WebhookTripDto setDepartureTime(ZonedDateTime departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public ZonedDateTime getArrivalTime() {
        return arrivalTime;
    }

    public WebhookTripDto setArrivalTime(ZonedDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public WebhookTripDto setAirlineName(String airlineName) {
        this.airlineName = airlineName;
        return this;
    }

    public Long getPlaneId() {
        return planeId;
    }

    public WebhookTripDto setPlaneId(Long planeId) {
        this.planeId = planeId;
        return this;
    }
}
