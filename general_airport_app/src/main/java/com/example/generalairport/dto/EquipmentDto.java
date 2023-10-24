package com.example.generalairport.dto;

import com.example.generalairport.entity.EquipmentType;

public class EquipmentDto {

    private Long id;
    private EquipmentType equipmentType;
    private String modelName;
    private Integer state;

    public Long getId() {
        return id;
    }

    public EquipmentDto setId(Long id) {
        this.id = id;
        return this;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public EquipmentDto setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
        return this;
    }

    public String getModelName() {
        return modelName;
    }

    public EquipmentDto setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public EquipmentDto setState(Integer state) {
        this.state = state;
        return this;
    }
}
