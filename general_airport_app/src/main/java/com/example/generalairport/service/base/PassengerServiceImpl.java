package com.example.generalairport.service.base;

import com.example.generalairport.entity.Passenger;
import com.example.generalairport.entity.Ticket;
import com.example.generalairport.entity.Trip;
import com.example.generalairport.exception.PassengerNotFoundException;
import com.example.generalairport.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;
    private final TicketService ticketService;
    private final TripService tripService;

    @Autowired
    public PassengerServiceImpl(
        PassengerRepository passengerRepository,
        TicketService ticketService,
        @Qualifier("tripServiceImpl") TripService tripService
    ) {
        this.passengerRepository = passengerRepository;
        this.ticketService = ticketService;
        this.tripService = tripService;
    }

    @Override
    public Page<Passenger> getAllPageable(Pageable pageable) {
        return passengerRepository.findAll(pageable);
    }

    @Override
    public Optional<Passenger> findById(Long id) {
        return passengerRepository.findById(id);
    }

    @Override
    public Passenger getById(Long id) {
        return findById(id).orElseThrow(() -> new PassengerNotFoundException());
    }

    /**
     * Билет не существует без пассажира, а пассажир не существует без билета, поэтому вот так костыльно
     * немного приходится персистить две энтити в одной транзакции
     * @param passenger
     * @return
     */
    @Override
    @Transactional
    public Passenger create(Passenger passenger, Ticket ticket) {
        Trip trip = tripService.getById(ticket.getTripId());
        ticket
            .setTrip(trip)
            .setTripId(trip.getId());

        ticketService.save(ticket);

        passenger.setTicket(ticket);
        passenger.setTicketId(ticket.getId());
        passengerRepository.save(passenger);

        ticket.setPassenger(passenger);
        ticket.setPassengerId(passenger.getId());
        return passenger;
    }

    @Override
    public Passenger update(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public void delete(Long id) {
        passengerRepository.deleteById(id);
    }
}
