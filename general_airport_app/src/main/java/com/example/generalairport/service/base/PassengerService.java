package com.example.generalairport.service.base;

import com.example.generalairport.entity.Passenger;
import com.example.generalairport.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PassengerService {

    Page<Passenger> getAllPageable(Pageable pageable);

    Optional<Passenger> findById(Long id);

    Passenger getById(Long id);

    Passenger create(Passenger passenger, Ticket ticket);

    Passenger update(Passenger passenger);

    void delete(Long id);

}
