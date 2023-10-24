package com.example.generalairport.entity;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
public class Trip extends BaseEntity<Long> {

    private String tripNumber;
    private String destinationCity;
    private String destinationCountry;
    private String destinationAirport;
    @Enumerated(EnumType.STRING)
    private TripStatus tripStatus;
    private ZonedDateTime departureTime;
    private ZonedDateTime arrivalTime;
    private String airlineName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plane_id")
    private Plane plane;
    @Column(name = "plane_id", insertable = false, updatable = false)
    private Long planeId;


    public String getTripNumber() {
        return tripNumber;
    }

    public Trip setTripNumber(String tripNumber) {
        this.tripNumber = tripNumber;
        return this;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public Trip setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
        return this;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public Trip setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
        return this;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public Trip setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
        return this;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public Trip setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
        return this;
    }

    public ZonedDateTime getDepartureTime() {
        return departureTime;
    }

    public Trip setDepartureTime(ZonedDateTime departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public ZonedDateTime getArrivalTime() {
        return arrivalTime;
    }

    public Trip setArrivalTime(ZonedDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public Trip setAirlineName(String airlineName) {
        this.airlineName = airlineName;
        return this;
    }

    public Plane getPlane() {
        return plane;
    }

    public Trip setPlane(Plane plane) {
        this.plane = plane;
        return this;
    }

    public Long getPlaneId() {
        return planeId;
    }

    public Trip setPlaneId(Long planeId) {
        this.planeId = planeId;
        return this;
    }
}
