package com.example.generalairport.service.webhook;

import com.example.generalairport.dto.webhook.AbstractWebhookDto;
import com.example.generalairport.dto.webhook.Webhook;
import com.example.generalairport.service.AirportEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WebhookGateway {
    private final String hostUrl;

    @Autowired
    public WebhookGateway(
        @Value("${airport.integration.webhook.host}") String hostUrl) {
        this.hostUrl = hostUrl;
    }

    public <T extends AbstractWebhookDto> void sendWebhook(AirportEvent event, T webhookDto) {

        Webhook<T> webhook = new Webhook<>();
        webhook.setBody(webhookDto);
        webhook.setEvent(event);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            String value = objectMapper.writeValueAsString(webhook);

            //FIXME тут поменять на нормальный эндпоинт, определенный в аппликейшен пропертисах. Так как эндпоинтов будет несколько,
            // то скореее всего придется написать что то вроде абстрактой фабрики, которая принимает
            // ивент и по этому ивенту понимает на какой эндпоинт послыать запрос
            HttpResponse<String> httpResponse = Unirest
                .post(hostUrl)
                .body(value).asString()
                ;

        } catch (JsonProcessingException | UnirestException e) {

        }
    }
}
