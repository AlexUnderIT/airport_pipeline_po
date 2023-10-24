package com.example.generalairport.entity;

import jakarta.persistence.Entity;

@Entity
public class Nationality extends BaseEntity<Long> {
    private String nationality;

    public String getNationality() {
        return nationality;
    }

    public Nationality setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }
}
