package com.example.generalairport.dto;

import com.example.generalairport.entity.EquipmentType;

/*
{
    "equipmentType": "LADDER",
    "modelName": "name",
    "state": "2",
    "tripId": "1"
}
 */

public class CreateEquipmentDto {

    private EquipmentType equipmentType;
    private String modelName;
    private Integer state;
    private Long tripId;

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public CreateEquipmentDto setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
        return this;
    }

    public String getModelName() {
        return modelName;
    }

    public CreateEquipmentDto setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public CreateEquipmentDto setState(Integer state) {
        this.state = state;
        return this;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }
}
