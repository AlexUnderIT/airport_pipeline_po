package com.example.generalairport.dto;

import com.example.generalairport.entity.Gender;
import com.example.generalairport.entity.SuspicionStatus;

import java.time.LocalDate;

public class PassengerDto {

    private Long id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private Gender gender;

    private String nationality;

    private TicketDto ticket;
    private String passportInfo;
    private String phoneNumber;
    private String email;

    private SuspicionStatus suspicionStatus;



    public Long getId() {
        return id;
    }

    public PassengerDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PassengerDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public PassengerDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public PassengerDto setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public PassengerDto setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public PassengerDto setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public TicketDto getTicket() {
        return ticket;
    }

    public PassengerDto setTicket(TicketDto ticket) {
        this.ticket = ticket;
        return this;
    }

    public String getPassportInfo() {
        return passportInfo;
    }

    public PassengerDto setPassportInfo(String passportInfo) {
        this.passportInfo = passportInfo;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PassengerDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PassengerDto setEmail(String email) {
        this.email = email;
        return this;
    }


    public SuspicionStatus getSuspicionStatus() {
        return suspicionStatus;
    }

    public PassengerDto setSuspicionStatus(SuspicionStatus suspicionStatus) {
        this.suspicionStatus = suspicionStatus;
        return this;
    }


}
