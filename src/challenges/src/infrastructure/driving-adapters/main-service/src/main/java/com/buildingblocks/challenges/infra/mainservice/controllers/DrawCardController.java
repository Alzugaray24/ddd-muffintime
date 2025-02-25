package com.buildingblocks.challenges.infra.mainservice.controllers;

import com.buildingblocks.challenges.application.player.drawcard.DrawCardRequest;
import com.buildingblocks.challenges.application.player.drawcard.DrawCardUseCase;
import com.buildingblocks.challenges.application.player.shared.PlayerResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/draw-card")
public class DrawCardController {
    private final DrawCardUseCase useCase;

    public DrawCardController(DrawCardUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Mono<PlayerResponse> drawCard(@RequestBody DrawCardRequest drawCardRequest) {
        return useCase.execute(drawCardRequest);
    }
}