package com.example.generalairport.dto;

import com.example.generalairport.entity.PlaneStatus;

/*
    "name": "Airbus A321",
    "planeStatus": "PARKING",
    "airlineName": "Aeroflot",
    "parkingName": "",
    "seatingCount": "100"
 */

public class CreatePlaneDto {

    private String name;
    private PlaneStatus planeStatus;
    private String airlineName;
    private String parkingName;
    private Integer seatingCount;

    public String getName() {
        return name;
    }

    public CreatePlaneDto setName(String name) {
        this.name = name;
        return this;
    }

    public PlaneStatus getPlaneStatus() {
        return planeStatus;
    }

    public CreatePlaneDto setPlaneStatus(PlaneStatus planeStatus) {
        this.planeStatus = planeStatus;
        return this;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public CreatePlaneDto setAirlineName(String airlineName) {
        this.airlineName = airlineName;
        return this;
    }

    public String getParkingName() {
        return parkingName;
    }

    public CreatePlaneDto setParkingName(String parkingName) {
        this.parkingName = parkingName;
        return this;
    }

    public Integer getSeatingCount() {
        return seatingCount;
    }

    public CreatePlaneDto setSeatingCount(Integer seatingCount) {
        this.seatingCount = seatingCount;
        return this;
    }
}
