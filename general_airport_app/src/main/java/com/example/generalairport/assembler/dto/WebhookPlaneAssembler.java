package com.example.generalairport.assembler.dto;

import com.example.generalairport.dto.webhook.WebhookPlaneDto;
import com.example.generalairport.entity.Plane;
import org.springframework.stereotype.Component;

@Component
public class WebhookPlaneAssembler {

    public WebhookPlaneDto toWebhookModel(Plane plane){

        WebhookPlaneDto webhookPlaneDto = new WebhookPlaneDto();

        webhookPlaneDto
            .setPlaneStatus(plane.getPlaneStatus())
            .setAirlineName(plane.getAirlineName())
            .setName(plane.getName())
            .setSeatingCount(plane.getSeatingCount());

        webhookPlaneDto.setId(plane.getId());


        return webhookPlaneDto;
    }
}
