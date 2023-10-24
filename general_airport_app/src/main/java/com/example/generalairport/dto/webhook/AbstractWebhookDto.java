package com.example.generalairport.dto.webhook;

public abstract class AbstractWebhookDto {
    private Long id;

    public Long getId() {
        return id;
    }

    public AbstractWebhookDto setId(Long id) {
        this.id = id;
        return this;
    }
}
