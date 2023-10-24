package com.example.generalairport.entity;

import jakarta.persistence.*;

@Entity
public class EquipmentToTrip extends BaseEntity<Long>{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;
    @Column(name = "equipment_id", insertable = false, updatable = false)
    private Long equipmentId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @Column(name = "trip_id", insertable = false, updatable = false)
    private Long tripId;

    public Equipment getEquipment() {
        return equipment;
    }

    public EquipmentToTrip setEquipment(Equipment equipment) {
        this.equipment = equipment;
        return this;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public EquipmentToTrip setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
        return this;
    }

    public Trip getTrip() {
        return trip;
    }

    public EquipmentToTrip setTrip(Trip trip) {
        this.trip = trip;
        return this;
    }

    public Long getTripId() {
        return tripId;
    }

    public EquipmentToTrip setTripId(Long tripId) {
        this.tripId = tripId;
        return this;
    }
}
