package com.example.generalairport.service.base;

import com.example.generalairport.entity.Equipment;
import com.example.generalairport.entity.EquipmentType;
import com.example.generalairport.repository.EquipmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EquipmentServiceImplTest {
    @Mock
    EquipmentRepository equipmentRepository;

    @InjectMocks
    EquipmentServiceImpl service;


    @Test
    void getById_returnValid() {
        Equipment testEquipment = new Equipment();
        testEquipment.setState(15)
                .setEquipmentType(EquipmentType.BUS)
                .setModelName("testModel")
                .setId(1L);

        Optional<Equipment> testOptional= Optional.of(testEquipment);

        var testId = 1L;
        when(equipmentRepository.findById(testId)).thenReturn(testOptional);

        var getTest = service.getById(testId);

        assertNotNull(getTest);
        assertEquals(EquipmentType.BUS, getTest.getEquipmentType());

        verify(equipmentRepository, times(1)).findById(Mockito.any());
    }

    @Test
    void getById_throwException() {
        Equipment testEquipment = new Equipment();
        testEquipment.setState(15)
                .setEquipmentType(EquipmentType.BUS)
                .setModelName("testModel")
                .setId(1L);

        Optional<Equipment> testOptional= Optional.of(testEquipment);

        var testId = 1L;
        when(equipmentRepository.findById(testId)).thenReturn(testOptional);

        var getTest = service.getById(testId);

        assertNotNull(getTest);
        assertEquals(EquipmentType.BUS, getTest.getEquipmentType());

        verify(equipmentRepository, times(1)).findById(Mockito.any());
    }


}