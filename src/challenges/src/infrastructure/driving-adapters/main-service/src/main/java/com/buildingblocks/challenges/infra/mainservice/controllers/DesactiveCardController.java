package com.buildingblocks.challenges.infra.mainservice.controllers;

import com.buildingblocks.challenges.application.card.desactivecard.DesactiveCardRequest;
import com.buildingblocks.challenges.application.card.desactivecard.DesactiveCardUseCase;
import com.buildingblocks.challenges.application.card.shared.CardResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/disable-card")
public class DesactiveCardController {
    private final DesactiveCardUseCase useCase;

    public DesactiveCardController(DesactiveCardUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Mono<CardResponse> desactivateCard(@RequestBody DesactiveCardRequest desactiveCardRequest) {
        return useCase.execute(desactiveCardRequest);
    }
}