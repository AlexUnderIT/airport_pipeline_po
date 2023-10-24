package com.example.generalairport.service.base;

import com.example.generalairport.entity.Ticket;
import com.example.generalairport.exception.TicketNotFoundException;
import com.example.generalairport.repository.TicketRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService{
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Page<Ticket> getAllPageable(Pageable pageable) {
        return ticketRepository.findAll(pageable);
    }

    public Ticket save(@NotNull Ticket ticket){
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getById(@NotNull Long ticketId) {
        return findById(ticketId).orElseThrow(() -> new TicketNotFoundException());
    }

    @Override
    public Optional<Ticket> findById(@NotNull Long ticketId) {
        return ticketRepository.findById(ticketId);
    }

    @Override
    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }
}
