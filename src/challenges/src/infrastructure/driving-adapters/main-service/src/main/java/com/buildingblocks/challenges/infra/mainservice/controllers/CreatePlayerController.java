package com.buildingblocks.challenges.infra.mainservice.controllers;

import com.buildingblocks.challenges.application.player.createplayer.CreatePlayerRequest;
import com.buildingblocks.challenges.application.player.createplayer.CreatePlayerUseCase;
import com.buildingblocks.challenges.application.player.shared.PlayerResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/create-player")
public class CreatePlayerController {
    private final CreatePlayerUseCase useCase;

    public CreatePlayerController(CreatePlayerUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Mono<PlayerResponse> createPlayer(@RequestBody CreatePlayerRequest createPlayerRequest) {
        return useCase.execute(createPlayerRequest);
    }
}
