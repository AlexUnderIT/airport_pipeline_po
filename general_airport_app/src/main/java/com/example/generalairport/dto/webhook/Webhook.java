package com.example.generalairport.dto.webhook;

import com.example.generalairport.service.AirportEvent;

public class Webhook <T extends AbstractWebhookDto> {
    private AirportEvent event;
    private T body;

    public AirportEvent getEvent() {
        return event;
    }

    public Webhook<T> setEvent(AirportEvent event) {
        this.event = event;
        return this;
    }

    public T getBody() {
        return body;
    }

    public Webhook<T> setBody(T body) {
        this.body = body;
        return this;
    }
}
