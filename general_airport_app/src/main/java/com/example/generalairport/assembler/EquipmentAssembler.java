package com.example.generalairport.assembler;

import com.example.generalairport.dto.EquipmentDto;
import com.example.generalairport.entity.Equipment;
import org.springframework.stereotype.Component;

@Component
public class EquipmentAssembler extends AbstractDtoAssembler<Equipment, EquipmentDto> {
    @Override
    public EquipmentDto toModel(Equipment entity) {
        EquipmentDto equipmentDto = new EquipmentDto();
        equipmentDto.setId(entity.getId());
        equipmentDto.setEquipmentType(entity.getEquipmentType());
        equipmentDto.setModelName(entity.getModelName());
        equipmentDto.setState(entity.getState());

        return equipmentDto;
    }
}
