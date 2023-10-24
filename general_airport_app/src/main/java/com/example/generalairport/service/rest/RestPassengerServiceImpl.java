package com.example.generalairport.service.rest;

import com.example.generalairport.assembler.PassengerAssembler;
import com.example.generalairport.dto.CreatePassengerDto;
import com.example.generalairport.dto.PassengerDto;
import com.example.generalairport.entity.Nationality;
import com.example.generalairport.entity.Passenger;
import com.example.generalairport.entity.Ticket;
import com.example.generalairport.service.base.NationalityService;
import com.example.generalairport.service.base.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

@Service
public class RestPassengerServiceImpl implements RestPassengerService {
    private final PassengerAssembler passengerAssembler;
    private final PassengerService passengerService;
    private final NationalityService nationalityService;

    @Autowired
    public RestPassengerServiceImpl(
        PassengerAssembler passengerAssembler,
        @Qualifier("webhookPassengerService") PassengerService passengerService,
        NationalityService nationalityService
    ) {
        this.passengerAssembler = passengerAssembler;
        this.passengerService = passengerService;
        this.nationalityService = nationalityService;
    }

    @Override
    public PagedModel<PassengerDto> getAllPageable(Pageable pageable) {
        return passengerAssembler.toPagedModel(passengerService.getAllPageable(pageable));
    }

    @Override
    public PassengerDto getById(Long id) {
        return passengerAssembler.toModel(passengerService.getById(id));
    }

    @Override
    public PassengerDto create(CreatePassengerDto createPassengerDto) {

        Nationality nationality = nationalityService.getFirstIgnoreCase(createPassengerDto.getNationality());
        Passenger passenger = new Passenger();
        passenger
            .setHasDangerousElectronics(createPassengerDto.getDangerousElectronics())
            .setHasWeapon(createPassengerDto.getHasWeapon())
            .setHasDangerousElectronics(createPassengerDto.getDangerousElectronics())
            .setHasDrugs(createPassengerDto.getHasDrugs())
            .setNationality(nationality)
            .setNationalityId(nationality.getId())
            .setGender(createPassengerDto.getGender())
            .setSurname(createPassengerDto.getSurname())
            .setEmail(createPassengerDto.getSurname())
            .setBirthday(createPassengerDto.getBirthday())
            .setPhoneNumber(createPassengerDto.getPhoneNumber())
            .setPassportInfo(createPassengerDto.getPassportInfo())
            .setName(createPassengerDto.getName())
        ;

        Ticket ticket = new Ticket();
        ticket
            .setSeatName(createPassengerDto.getSeatName())
            .setHandicapped(createPassengerDto.getHandicapped())
            .setSeatClass(createPassengerDto.getSeatClass())
            .setHasPets(createPassengerDto.getHasPets())
            .setHasFood(createPassengerDto.getHasFood())
            .setHasBaggage(createPassengerDto.getHasBaggage())
            .setHasGabBaggage(createPassengerDto.getHasBaggage())
            .setTransferToPlainType(createPassengerDto.getTransferToPlain())
            .setTripId(createPassengerDto.getTripId())
        ;

        passenger.setTicket(ticket);

        return passengerAssembler.toModel(passengerService.create(passenger, ticket));
    }

    @Override
    public PassengerDto update(Long id, PassengerDto passengerDto) {
        Nationality nationality = nationalityService.getFirstIgnoreCase(passengerDto.getNationality());
        Passenger updatedPassenger = passengerService.getById(id);
        updatedPassenger.setName(passengerDto.getName());
        updatedPassenger.setSurname(passengerDto.getSurname());
        updatedPassenger.setBirthday(passengerDto.getBirthday());
        updatedPassenger.setGender(passengerDto.getGender());
        updatedPassenger.setNationality(nationality);
        updatedPassenger.setPassportInfo(passengerDto.getPassportInfo());
        updatedPassenger.setPhoneNumber(passengerDto.getPhoneNumber());
        updatedPassenger.setEmail(passengerDto.getEmail());
        updatedPassenger.setSuspicionStatus(passengerDto.getSuspicionStatus());

        return passengerAssembler.toModel(passengerService.update(updatedPassenger));
    }

    @Override
    public void delete(Long id) {
        passengerService.delete(id);
    }
}
