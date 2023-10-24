package com.example.generalairport.service.base;

import com.example.generalairport.entity.Plane;
import com.example.generalairport.exception.PlaneNotFoundException;
import com.example.generalairport.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaneServiceImpl implements PlaneService {
    private final PlaneRepository planeRepository;

    @Autowired
    public PlaneServiceImpl(PlaneRepository planeRepository) { this.planeRepository = planeRepository; }

    @Override
    public Page<Plane> getAllPageable(Pageable pageable) {
        return planeRepository.findAll(pageable);
    }

    @Override
    public Optional<Plane> findById(Long id) {
        return planeRepository.findById(id);
    }

    @Override
    public Plane getById(Long id) { return findById(id).orElseThrow(() -> new PlaneNotFoundException()); }

    @Override
    public Plane save(Plane plane) {
        return planeRepository.save(plane);
    }

    @Override
    public void delete(Long id) { planeRepository.deleteById(id); }
}
