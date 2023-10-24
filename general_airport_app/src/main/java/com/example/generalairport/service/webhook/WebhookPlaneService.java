package com.example.generalairport.service.webhook;

import com.example.generalairport.assembler.dto.WebhookPlaneAssembler;
import com.example.generalairport.entity.Plane;
import com.example.generalairport.service.AirportEvent;
import com.example.generalairport.service.base.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WebhookPlaneService implements PlaneService {
    private final WebhookGateway webhookGateway;
    private final PlaneService planeService;
    private final WebhookPlaneAssembler webhookPlaneAssembler;

    @Autowired
    public WebhookPlaneService(
        WebhookGateway webhookGateway,
        @Qualifier("planeServiceImpl") PlaneService planeService,
        WebhookPlaneAssembler webhookPlaneAssembler
    ) {
        this.webhookGateway = webhookGateway;
        this.planeService = planeService;
        this.webhookPlaneAssembler = webhookPlaneAssembler;
    }

    @Override
    public Page<Plane> getAllPageable(Pageable pageable) {
        return planeService.getAllPageable(pageable);
    }

    @Override
    public Optional<Plane> findById(Long id) {
        return planeService.findById(id);
    }

    @Override
    public Plane getById(Long id) {
        return planeService.getById(id);
    }

    @Override
    public Plane save(Plane plane) {
        boolean isNew = plane.isNew();
        Plane createdPlane = planeService.save(plane);

        webhookGateway.sendWebhook(
            isNew ? AirportEvent.PLANE_CREATE : AirportEvent.PLANE_UPDATE,
            webhookPlaneAssembler.toWebhookModel(createdPlane)
        );

        return createdPlane;
    }

    @Override
    public void delete(Long id) {
        planeService.delete(id);
    }
}
