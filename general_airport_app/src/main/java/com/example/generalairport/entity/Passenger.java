package com.example.generalairport.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Passenger extends BaseEntity<Long> {

    private String name;
    private String surname;
    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nationality_id")
    private Nationality nationality;
    @Column(name = "nationality_id", insertable = false, updatable = false)
    private Long nationalityId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
    @Column(name = "ticket_id", insertable = false, updatable = false)
    private Long ticketId;

    private String passportInfo;
    private String phoneNumber;
    private String email;

    private Boolean hasWeapon = Boolean.FALSE;
    private Boolean hasDrugs = Boolean.FALSE;
    private Boolean hasDangerousElectronics = Boolean.FALSE;
    @Enumerated(EnumType.STRING)
    private SuspicionStatus suspicionStatus = SuspicionStatus.NONE;

    public String getName() {
        return name;
    }

    public Passenger setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Passenger setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Passenger setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Passenger setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public Passenger setNationality(Nationality nationality) {
        this.nationality = nationality;
        return this;
    }

    public Long getNationalityId() {
        return nationalityId;
    }

    public Passenger setNationalityId(Long nationalityId) {
        this.nationalityId = nationalityId;
        return this;
    }

    public String getPassportInfo() {
        return passportInfo;
    }

    public Passenger setPassportInfo(String passportInfo) {
        this.passportInfo = passportInfo;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Passenger setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Passenger setEmail(String email) {
        this.email = email;
        return this;
    }


    public Ticket getTicket() {
        return ticket;
    }

    public Passenger setTicket(Ticket ticket) {
        this.ticket = ticket;
        return this;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public Passenger setTicketId(Long ticketId) {
        this.ticketId = ticketId;
        return this;
    }

    public Boolean getHasWeapon() {
        return hasWeapon;
    }

    public Passenger setHasWeapon(Boolean hasWeapon) {
        this.hasWeapon = hasWeapon;
        return this;
    }

    public Boolean getHasDrugs() {
        return hasDrugs;
    }

    public Passenger setHasDrugs(Boolean hasDrugs) {
        this.hasDrugs = hasDrugs;
        return this;
    }

    public Boolean getHasDangerousElectronics() {
        return hasDangerousElectronics;
    }

    public Passenger setHasDangerousElectronics(Boolean hasDangerousElectronics) {
        this.hasDangerousElectronics = hasDangerousElectronics;
        return this;
    }

    public SuspicionStatus getSuspicionStatus() {
        return suspicionStatus;
    }

    public Passenger setSuspicionStatus(SuspicionStatus suspicionStatus) {
        this.suspicionStatus = suspicionStatus;
        return this;
    }
}
