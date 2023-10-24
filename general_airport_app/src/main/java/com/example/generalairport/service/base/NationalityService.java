package com.example.generalairport.service.base;

import com.example.generalairport.entity.Nationality;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public interface NationalityService {

    Optional<Nationality> findFirstIgnoreCase(@NotNull String value);

    Nationality getFirstIgnoreCase(@NotNull String value);

    Nationality getById(Long id);
}
