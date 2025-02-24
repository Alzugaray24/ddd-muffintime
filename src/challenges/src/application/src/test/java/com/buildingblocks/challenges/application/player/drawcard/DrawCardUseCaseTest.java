// DrawCardUseCaseTest.java
package com.buildingblocks.challenges.application.player.drawcard;

import com.buildingblocks.challenges.application.shared.IEventRepository;
import com.buildingblocks.challenges.application.shared.PlayerResponse;
import com.buildingblocks.challenges.domain.player.Player;
import com.buildingblocks.challenges.domain.player.events.CardDrawn;
import com.buildingblocks.challenges.domain.player.events.PlayerCreated;
import com.buildingblocks.challenges.domain.player.values.NickName;
import com.buildingblocks.shared.domain.generic.DomainEvent;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class DrawCardUseCaseTest {

    private final IEventRepository eventRepository = Mockito.mock(IEventRepository.class);
    private final DrawCardUseCase useCase = new DrawCardUseCase(eventRepository);

    @Test
    void executeSuccess() {
        // Arrange
        String aggregateId = "player-123";
        String cardId = "card-456";
        String nickname = "PlayerOne";
        DrawCardRequest request = new DrawCardRequest(aggregateId, cardId, nickname);
        when(eventRepository.findEventsByAggregateId(aggregateId)).thenReturn(Flux.fromIterable(Collections.emptyList()));

        // Act
        Mono<PlayerResponse> result = useCase.execute(request);

        // Assert
        StepVerifier.create(result)
                .expectNextMatches(response -> response.getPlayerId().equals(aggregateId))
                .verifyComplete();

        Mockito.verify(eventRepository).save(any(CardDrawn.class));
    }

    @Test
    void executeWithExistingEvents() {
        // Arrange
        String aggregateId = "player-123";
        String cardId = "card-456";
        String nickname = "PlayerOne";
        DrawCardRequest request = new DrawCardRequest(aggregateId, cardId, nickname);
        DomainEvent playerCreatedEvent = new PlayerCreated(nickname);
        when(eventRepository.findEventsByAggregateId(aggregateId)).thenReturn(Flux.just(playerCreatedEvent));

        // Act
        Mono<PlayerResponse> result = useCase.execute(request);

        // Assert
        StepVerifier.create(result)
                .expectNextMatches(response -> response.getPlayerId().equals(aggregateId))
                .verifyComplete();

        Mockito.verify(eventRepository).save(any(CardDrawn.class));
    }

}