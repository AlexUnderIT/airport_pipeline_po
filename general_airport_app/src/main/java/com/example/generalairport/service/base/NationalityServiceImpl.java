package com.example.generalairport.service.base;

import com.example.generalairport.entity.Nationality;
import com.example.generalairport.exception.NationalityNotFoundException;
import com.example.generalairport.repository.NationalityRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NationalityServiceImpl implements NationalityService {

    private final NationalityRepository nationalityRepository;

    @Autowired
    public NationalityServiceImpl(NationalityRepository nationalityRepository) {
        this.nationalityRepository = nationalityRepository;
    }

    @Override
    public Optional<Nationality> findFirstIgnoreCase(@NotNull String value) {
        return nationalityRepository.findFirstByNationalityIgnoreCase(value);
    }

    @Override
    public Nationality getFirstIgnoreCase(@NotNull String value) {
        return findFirstIgnoreCase(value).orElseThrow(() -> new NationalityNotFoundException());
    }

    @Override
    public Nationality getById(Long id) {
        return nationalityRepository.findById(id).orElseThrow(() -> new NationalityNotFoundException());
    }
}
