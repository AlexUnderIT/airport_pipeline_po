package com.example.generalairport.dto.webhook;

import com.example.generalairport.entity.PlaneStatus;

public class WebhookPlaneDto  extends AbstractWebhookDto{
    private String name;
    private PlaneStatus planeStatus;
    private String airlineName;
    private Integer seatingCount;


    public String getName() {
        return name;
    }

    public WebhookPlaneDto setName(String name) {
        this.name = name;
        return this;
    }

    public PlaneStatus getPlaneStatus() {
        return planeStatus;
    }

    public WebhookPlaneDto setPlaneStatus(PlaneStatus planeStatus) {
        this.planeStatus = planeStatus;
        return this;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public WebhookPlaneDto setAirlineName(String airlineName) {
        this.airlineName = airlineName;
        return this;
    }

    public Integer getSeatingCount() {
        return seatingCount;
    }

    public WebhookPlaneDto setSeatingCount(Integer seatingCount) {
        this.seatingCount = seatingCount;
        return this;
    }
}
