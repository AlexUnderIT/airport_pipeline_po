package com.example.generalairport.service.rest;

import com.example.generalairport.dto.TicketDto;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

public interface RestTicketService {
    PagedModel<TicketDto> getAllPageable(Pageable pageable);

    TicketDto getById(Long id);

    TicketDto update(Long id, TicketDto ticketDto);

    void delete(Long id);
}
