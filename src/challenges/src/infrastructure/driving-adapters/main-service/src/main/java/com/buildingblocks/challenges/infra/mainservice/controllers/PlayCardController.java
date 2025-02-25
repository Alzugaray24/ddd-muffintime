package com.buildingblocks.challenges.infra.mainservice.controllers;

import com.buildingblocks.challenges.application.player.playcard.PlayCardRequest;
import com.buildingblocks.challenges.application.player.playcard.PlayCardUseCase;
import com.buildingblocks.challenges.application.player.shared.PlayerResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/play-card")
public class PlayCardController {
    private final PlayCardUseCase useCase;

    public PlayCardController(PlayCardUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Mono<PlayerResponse> playCard(@RequestBody PlayCardRequest playCardRequest) {
        return useCase.execute(playCardRequest);
    }
}