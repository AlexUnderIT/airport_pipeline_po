package com.example.generalairport.entity;

import jakarta.persistence.*;

@Entity
public class Ticket extends BaseEntity<Long>{

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
    private Passenger passenger;

    @Column(name = "passenger_id", insertable = false, updatable = false)
    private Long passengerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @Column(name = "trip_id", insertable = false, updatable = false)
    private Long tripId;

    private Boolean hasBaggage = Boolean.FALSE;
    private Boolean hasGabBaggage = Boolean.FALSE;
    private Boolean hasFood = Boolean.FALSE;
    private Boolean hasPets = Boolean.FALSE;
    private Boolean isHandicapped = Boolean.FALSE;

    private String seatName;
    private String seatClass;

    @Enumerated(EnumType.STRING)
    private TransferToPlainType transferToPlainType;


    public Passenger getPassenger() {
        return passenger;
    }

    public Ticket setPassenger(Passenger passenger) {
        this.passenger = passenger;
        return this;
    }

    public Trip getTrip() {
        return trip;
    }

    public Ticket setTrip(Trip trip) {
        this.trip = trip;
        return this;
    }

    public Long getTripId() {
        return tripId;
    }

    public Ticket setTripId(Long tripId) {
        this.tripId = tripId;
        return this;
    }

    public Boolean getHasBaggage() {
        return hasBaggage;
    }

    public Ticket setHasBaggage(Boolean hasBaggage) {
        this.hasBaggage = hasBaggage;
        return this;
    }

    public Boolean getHasFood() {
        return hasFood;
    }

    public Ticket setHasFood(Boolean hasFood) {
        this.hasFood = hasFood;
        return this;
    }

    public Boolean getHasPets() {
        return hasPets;
    }

    public Ticket setHasPets(Boolean hasPets) {
        this.hasPets = hasPets;
        return this;
    }

    public String getSeatName() {
        return seatName;
    }

    public Ticket setSeatName(String seatName) {
        this.seatName = seatName;
        return this;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public Ticket setSeatClass(String seatClass) {
        this.seatClass = seatClass;
        return this;
    }

    public Boolean getHasGabBaggage() {
        return hasGabBaggage;
    }

    public Ticket setHasGabBaggage(Boolean hasGabBaggage) {
        this.hasGabBaggage = hasGabBaggage;
        return this;
    }

    public Boolean getHandicapped() {
        return isHandicapped;
    }

    public Ticket setHandicapped(Boolean handicapped) {
        isHandicapped = handicapped;
        return this;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public Ticket setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
        return this;
    }

    public TransferToPlainType getTransferToPlainType() {
        return transferToPlainType;
    }

    public Ticket setTransferToPlainType(TransferToPlainType transferToPlainType) {
        this.transferToPlainType = transferToPlainType;
        return this;
    }
}
