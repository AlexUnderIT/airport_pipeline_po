package com.example.generalairport.dto.webhook;

import com.example.generalairport.entity.Gender;
import com.example.generalairport.entity.SuspicionStatus;
import com.example.generalairport.entity.TransferToPlainType;

import java.time.LocalDate;

public class WebhookPassengerDto extends AbstractWebhookDto {
    private String name;
    private String surname;
    private LocalDate birthday;
    private Gender gender;

    private String nationality;

    private String passportInfo;
    private String phoneNumber;
    private String email;
    private SuspicionStatus suspicionStatus;


    private Boolean hasBaggage;
    private Boolean hasFood;
    private Boolean hasPets;

    private Boolean hasWeapon;
    private Boolean hasDrugs;
    private Boolean dangerousElectronics;
    private Long tripId;

    private Boolean isHandicapped;

    private String seatName;
    private String seatClass;
    private TransferToPlainType transferToPlainType;

    public String getName() {
        return name;
    }

    public WebhookPassengerDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public WebhookPassengerDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public WebhookPassengerDto setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public WebhookPassengerDto setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public WebhookPassengerDto setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public String getPassportInfo() {
        return passportInfo;
    }

    public WebhookPassengerDto setPassportInfo(String passportInfo) {
        this.passportInfo = passportInfo;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public WebhookPassengerDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public WebhookPassengerDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public Boolean getHasBaggage() {
        return hasBaggage;
    }

    public WebhookPassengerDto setHasBaggage(Boolean hasBaggage) {
        this.hasBaggage = hasBaggage;
        return this;
    }

    public Boolean getHasFood() {
        return hasFood;
    }

    public WebhookPassengerDto setHasFood(Boolean hasFood) {
        this.hasFood = hasFood;
        return this;
    }

    public Boolean getHasPets() {
        return hasPets;
    }

    public WebhookPassengerDto setHasPets(Boolean hasPets) {
        this.hasPets = hasPets;
        return this;
    }

    public SuspicionStatus getSuspicionStatus() {
        return suspicionStatus;
    }

    public WebhookPassengerDto setSuspicionStatus(SuspicionStatus suspicionStatus) {
        this.suspicionStatus = suspicionStatus;
        return this;
    }

    public Boolean getHasWeapon() {
        return hasWeapon;
    }

    public WebhookPassengerDto setHasWeapon(Boolean hasWeapon) {
        this.hasWeapon = hasWeapon;
        return this;
    }

    public Boolean getHasDrugs() {
        return hasDrugs;
    }

    public WebhookPassengerDto setHasDrugs(Boolean hasDrugs) {
        this.hasDrugs = hasDrugs;
        return this;
    }

    public Boolean getDangerousElectronics() {
        return dangerousElectronics;
    }

    public WebhookPassengerDto setDangerousElectronics(Boolean dangerousElectronics) {
        this.dangerousElectronics = dangerousElectronics;
        return this;
    }

    public Long getTripId() {
        return tripId;
    }

    public WebhookPassengerDto setTripId(Long tripId) {
        this.tripId = tripId;
        return this;
    }

    public Boolean getHandicapped() {
        return isHandicapped;
    }

    public WebhookPassengerDto setHandicapped(Boolean handicapped) {
        isHandicapped = handicapped;
        return this;
    }

    public String getSeatName() {
        return seatName;
    }

    public WebhookPassengerDto setSeatName(String seatName) {
        this.seatName = seatName;
        return this;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public WebhookPassengerDto setSeatClass(String seatClass) {
        this.seatClass = seatClass;
        return this;
    }

    public TransferToPlainType getTransferToPlainType() {
        return transferToPlainType;
    }

    public WebhookPassengerDto setTransferToPlainType(TransferToPlainType transferToPlainType) {
        this.transferToPlainType = transferToPlainType;
        return this;
    }
}
