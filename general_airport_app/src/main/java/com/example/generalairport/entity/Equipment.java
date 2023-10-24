package com.example.generalairport.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Equipment extends BaseEntity<Long> {
    @Enumerated(EnumType.STRING)
    private EquipmentType equipmentType;
    private String modelName;
    private Integer state;

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public Equipment setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
        return this;
    }

    public String getModelName() {
        return modelName;
    }

    public Equipment setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public Equipment setState(Integer state) {
        this.state = state;
        return this;
    }
}
