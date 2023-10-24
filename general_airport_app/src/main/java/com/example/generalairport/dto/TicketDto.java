package com.example.generalairport.dto;

import com.example.generalairport.entity.TransferToPlainType;

public class TicketDto {

    private Long id;
    private Boolean hasBaggage = Boolean.FALSE;
    private Boolean hasFood = Boolean.FALSE;
    private Boolean hasPets = Boolean.FALSE;
    private String seatName;
    private String seatClass;

    private TransferToPlainType transferToPlainType;

    public Long getId() {
        return id;
    }

    public TicketDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Boolean getHasBaggage() {
        return hasBaggage;
    }

    public TicketDto setHasBaggage(Boolean hasBaggage) {
        this.hasBaggage = hasBaggage;
        return this;
    }

    public Boolean getHasFood() {
        return hasFood;
    }

    public TicketDto setHasFood(Boolean hasFood) {
        this.hasFood = hasFood;
        return this;
    }

    public Boolean getHasPets() {
        return hasPets;
    }

    public TicketDto setHasPets(Boolean hasPets) {
        this.hasPets = hasPets;
        return this;
    }

    public TransferToPlainType getTransferToPlainType() {
        return transferToPlainType;
    }

    public TicketDto setTransferToPlainType(TransferToPlainType transferToPlainType) {
        this.transferToPlainType = transferToPlainType;
        return this;
    }

    public String getSeatName() {
        return seatName;
    }

    public TicketDto setSeatName(String seatName) {
        this.seatName = seatName;
        return this;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public TicketDto setSeatClass(String seatClass) {
        this.seatClass = seatClass;
        return this;
    }
}
