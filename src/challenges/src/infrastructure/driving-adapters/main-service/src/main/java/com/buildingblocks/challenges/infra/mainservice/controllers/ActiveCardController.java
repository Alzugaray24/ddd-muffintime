package com.buildingblocks.challenges.infra.mainservice.controllers;

import com.buildingblocks.challenges.application.card.activecard.ActiveCardRequest;
import com.buildingblocks.challenges.application.card.activecard.ActiveCardUseCase;
import com.buildingblocks.challenges.application.card.shared.CardResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/activate-card")
public class ActiveCardController {
    private final ActiveCardUseCase useCase;

    public ActiveCardController(ActiveCardUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Mono<CardResponse> activateCard(@RequestBody ActiveCardRequest activeCardRequest) {
        return useCase.execute(activeCardRequest);
    }
}