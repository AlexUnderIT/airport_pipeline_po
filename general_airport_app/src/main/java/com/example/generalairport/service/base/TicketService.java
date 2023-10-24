package com.example.generalairport.service.base;

import com.example.generalairport.entity.Passenger;
import com.example.generalairport.entity.Ticket;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TicketService {

    Page<Ticket> getAllPageable(Pageable pageable);

    Ticket save(@NotNull Ticket ticket);

    Ticket getById(@NotNull Long ticketId);

    Optional<Ticket> findById(@NotNull Long ticketId);

    void delete(Long id);
}
