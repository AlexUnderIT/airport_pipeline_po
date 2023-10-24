package com.example.generalairport.dto;

import com.example.generalairport.entity.TripStatus;

import java.time.ZonedDateTime;

public class TripDto {

    private Long id;
    private String tripNumber;
    private String destinationCity;
    private String destinationCountry;
    private String destinationAirport;
    private TripStatus tripStatus;
    private ZonedDateTime departureTime;
    private ZonedDateTime arrivalTime;
    private String airlineName;
    private Long planeId;

    public Long getId() {
        return id;
    }

    public TripDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTripNumber() {
        return tripNumber;
    }

    public TripDto setTripNumber(String tripNumber) {
        this.tripNumber = tripNumber;
        return this;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public TripDto setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
        return this;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public TripDto setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
        return this;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public TripDto setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
        return this;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public TripDto setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
        return this;
    }

    public ZonedDateTime getDepartureTime() {
        return departureTime;
    }

    public TripDto setDepartureTime(ZonedDateTime departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public ZonedDateTime getArrivalTime() {
        return arrivalTime;
    }

    public TripDto setArrivalTime(ZonedDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public TripDto setAirlineName(String airlineName) {
        this.airlineName = airlineName;
        return this;
    }

    public Long getPlaneId() {
        return planeId;
    }

    public TripDto setPlaneId(Long planeId) {
        this.planeId = planeId;
        return this;
    }
}
