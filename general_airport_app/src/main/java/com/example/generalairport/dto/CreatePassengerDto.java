package com.example.generalairport.dto;

import com.example.generalairport.entity.Gender;
import com.example.generalairport.entity.TransferToPlainType;

import java.time.LocalDate;

//{
//    "name": "Alex",
//    "surname": "Menshov",
//    "birthday": "2023-09-17",
//    "gender": "MALE",
//    "nationality": "Russian",
//    "passportInfo":"123232",
//    "phoneNumber":"23213123",
//    "email": "aleks7777k2@gmail.com",
//    "hasBaggage": true,
//    "hasFood": true,
//    "hasPets": false,
//    "hasWeapon":false,
//    "hasDrugs": true,
//    "dangerousElectronics": false,
//    "isHandicapped": true,
//    "seatName": "D23",
//    "transferToPlain": "BUSINESS_BUS",
//    "seatClass": "BUIZNES",
//    "tripId": 1
//}

public class CreatePassengerDto {

    private String name;
    private String surname;
    private LocalDate birthday;
    private Gender gender;

    private String nationality;

    private String passportInfo;
    private String phoneNumber;
    private String email;

    private Boolean hasBaggage;
    private Boolean hasFood;
    private Boolean hasPets;

    private Boolean hasWeapon = Boolean.FALSE;
    private Boolean hasDrugs = Boolean.FALSE;
    private Boolean dangerousElectronics = Boolean.FALSE;
    private Long tripId;

    private Boolean isHandicapped = Boolean.FALSE;

    private String seatName;
    private String seatClass;
    private TransferToPlainType transferToPlain;


    public String getName() {
        return name;
    }

    public CreatePassengerDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public CreatePassengerDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public CreatePassengerDto setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public CreatePassengerDto setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public CreatePassengerDto setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public String getPassportInfo() {
        return passportInfo;
    }

    public CreatePassengerDto setPassportInfo(String passportInfo) {
        this.passportInfo = passportInfo;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CreatePassengerDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreatePassengerDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public Boolean getHasBaggage() {
        return hasBaggage;
    }

    public CreatePassengerDto setHasBaggage(Boolean hasBaggage) {
        this.hasBaggage = hasBaggage;
        return this;
    }

    public Boolean getHasFood() {
        return hasFood;
    }

    public CreatePassengerDto setHasFood(Boolean hasFood) {
        this.hasFood = hasFood;
        return this;
    }

    public Boolean getHasPets() {
        return hasPets;
    }

    public CreatePassengerDto setHasPets(Boolean hasPets) {
        this.hasPets = hasPets;
        return this;
    }

    public Boolean getHasWeapon() {
        return hasWeapon;
    }

    public CreatePassengerDto setHasWeapon(Boolean hasWeapon) {
        this.hasWeapon = hasWeapon;
        return this;
    }

    public Boolean getHasDrugs() {
        return hasDrugs;
    }

    public CreatePassengerDto setHasDrugs(Boolean hasDrugs) {
        this.hasDrugs = hasDrugs;
        return this;
    }

    public Boolean getDangerousElectronics() {
        return dangerousElectronics;
    }

    public CreatePassengerDto setDangerousElectronics(Boolean dangerousElectronics) {
        this.dangerousElectronics = dangerousElectronics;
        return this;
    }

    public Boolean getHandicapped() {
        return isHandicapped;
    }

    public CreatePassengerDto setHandicapped(Boolean handicapped) {
        isHandicapped = handicapped;
        return this;
    }

    public String getSeatName() {
        return seatName;
    }

    public CreatePassengerDto setSeatName(String seatName) {
        this.seatName = seatName;
        return this;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public CreatePassengerDto setSeatClass(String seatClass) {
        this.seatClass = seatClass;
        return this;
    }

    public TransferToPlainType getTransferToPlain() {
        return transferToPlain;
    }

    public CreatePassengerDto setTransferToPlain(TransferToPlainType transferToPlain) {
        this.transferToPlain = transferToPlain;
        return this;
    }

    public Long getTripId() {
        return tripId;
    }

    public CreatePassengerDto setTripId(Long tripId) {
        this.tripId = tripId;
        return this;
    }
}
