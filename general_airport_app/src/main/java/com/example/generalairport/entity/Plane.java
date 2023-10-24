package com.example.generalairport.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Plane extends BaseEntity<Long> {
    private String name;
    @Enumerated(EnumType.STRING)
    private PlaneStatus planeStatus;
    private String airlineName;
    private String parkingName;
    private Integer seatingCount;

    public String getName() {
        return name;
    }

    public Plane setName(String name) {
        this.name = name;
        return this;
    }

    public PlaneStatus getPlaneStatus() {
        return planeStatus;
    }

    public Plane setPlaneStatus(PlaneStatus planeStatus) {
        this.planeStatus = planeStatus;
        return this;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public Plane setAirlineName(String airlineName) {
        this.airlineName = airlineName;
        return this;
    }

    public String getParkingName() {
        return parkingName;
    }

    public Plane setParkingName(String parkingName) {
        this.parkingName = parkingName;
        return this;
    }

    public Integer getSeatingCount() {
        return seatingCount;
    }

    public Plane setSeatingCount(Integer seatingCount) {
        this.seatingCount = seatingCount;
        return this;
    }
}
