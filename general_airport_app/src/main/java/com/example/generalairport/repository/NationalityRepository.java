package com.example.generalairport.repository;

import com.example.generalairport.entity.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NationalityRepository extends JpaRepository<Nationality, Long> {
    Optional<Nationality> findFirstByNationalityIgnoreCase(String nationality);
}
