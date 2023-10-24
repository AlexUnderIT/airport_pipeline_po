package com.example.generalairport.dto;

import com.example.generalairport.entity.TripStatus;

import java.time.ZonedDateTime;

/*
    "tripNumber": "1",
    "destinationCity": "Moscow",
    "destinationCountry": "Russia",
    "destinationAirport": "VKO",
    "tripStatus": "CANCELED",
    "departureTime": "2019-08-27T00:12:55.333+08:00[Asia/Singapore]",
    "arrivalTime": "2019-08-27T04:12:00.333+08:00[Asia/Singapore]",
    "airlineName": "Aeroflot",
    "planeId": "1"
 */
public class CreateTripDto {

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

    public CreateTripDto setTripNumber(String tripNumber) {
        this.tripNumber = tripNumber;
        return this;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public CreateTripDto setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
        return this;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public CreateTripDto setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
        return this;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public CreateTripDto setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
        return this;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public CreateTripDto setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
        return this;
    }

    public ZonedDateTime getDepartureTime() {
        return departureTime;
    }

    public CreateTripDto setDepartureTime(ZonedDateTime departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public ZonedDateTime getArrivalTime() {
        return arrivalTime;
    }

    public CreateTripDto setArrivalTime(ZonedDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public CreateTripDto setAirlineName(String airlineName) {
        this.airlineName = airlineName;
        return this;
    }

    public Long getPlaneId() {
        return planeId;
    }

    public CreateTripDto setPlaneId(Long planeId) {
        this.planeId = planeId;
        return this;
    }
}