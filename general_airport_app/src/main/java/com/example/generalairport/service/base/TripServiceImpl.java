package com.example.generalairport.service.base;

import com.example.generalairport.entity.Trip;
import com.example.generalairport.exception.TripNotFoundException;
import com.example.generalairport.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;

    @Autowired
    public TripServiceImpl(
        TripRepository tripRepository
    ) {
        this.tripRepository = tripRepository;
    }

    @Override
    public Page<Trip> getAllPageable(Pageable pageable) {
        return tripRepository.findAll(pageable);
    }

    @Override
    public Optional<Trip> findById(Long id) {
        return tripRepository.findById(id);
    }

    @Override
    public Trip getById(Long id) { return findById(id).orElseThrow(() -> new TripNotFoundException()); }

    @Override
    public Trip save(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public void delete(Long id) { tripRepository.deleteById(id); }
}
