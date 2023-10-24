package com.example.generalairport.dto;

import com.example.generalairport.entity.PlaneStatus;

public class PlaneDto {

    private Long id;
    private String name;
    private PlaneStatus planeStatus;
    private String airlineName;
    private Integer seatingCount;

    public Long getId() {
        return id;
    }

    public PlaneDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PlaneDto setName(String name) {
        this.name = name;
        return this;
    }

    public PlaneStatus getPlaneStatus() {
        return planeStatus;
    }

    public PlaneDto setPlaneStatus(PlaneStatus planeStatus) {
        this.planeStatus = planeStatus;
        return this;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public PlaneDto setAirlineName(String airlineName) {
        this.airlineName = airlineName;
        return this;
    }

    public Integer getSeatingCount() {
        return seatingCount;
    }

    public PlaneDto setSeatingCount(Integer seatingCount) {
        this.seatingCount = seatingCount;
        return this;
    }
}
