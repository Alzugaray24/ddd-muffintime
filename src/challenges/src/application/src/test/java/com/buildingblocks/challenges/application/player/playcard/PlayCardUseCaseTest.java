//// PlayCardUseCaseTest.java
//package com.buildingblocks.challenges.application.player.playcard;
//
//import com.buildingblocks.challenges.application.shared.ports.IEventRepositoryPort;
//import com.buildingblocks.challenges.application.player.shared.PlayerResponse;
//import com.buildingblocks.challenges.domain.player.events.CardPlayed;
//import com.buildingblocks.challenges.domain.player.events.PlayerCreated;
//import com.buildingblocks.shared.domain.generic.DomainEvent;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//import java.util.Collections;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//class PlayCardUseCaseTest {
//
//    private final IEventRepositoryPort eventRepository = Mockito.mock(IEventRepositoryPort.class);
//    private final PlayCardUseCase useCase = new PlayCardUseCase(eventRepository);
//
//    @Test
//    void executeSuccess() {
//        // Arrange
//        String aggregateId = "player-123";
//        String cardId = "card-456";
//        String action = "some-action";
//        String playerId = "player-123";
//        String nickname = "PlayerOne";
//        PlayCardRequest request = new PlayCardRequest(aggregateId, cardId, action, playerId, nickname);
//        when(eventRepository.findEventsByAggregateId(aggregateId)).thenReturn(Flux.fromIterable(Collections.emptyList()));
//
//        // Act
//        Mono<PlayerResponse> result = useCase.execute(request);
//
//        // Assert
//        StepVerifier.create(result)
//                .expectNextMatches(response -> response.getPlayerId().equals(aggregateId))
//                .verifyComplete();
//
//        Mockito.verify(eventRepository).save(any(CardPlayed.class));
//    }
//
//    @Test
//    void executeWithExistingEvents() {
//        // Arrange
//        String aggregateId = "player-123";
//        String cardId = "card-456";
//        String action = "some-action";
//        String playerId = "player-123";
//        String nickname = "PlayerOne";
//        PlayCardRequest request = new PlayCardRequest(aggregateId, cardId, action, playerId, nickname);
//        DomainEvent playerCreatedEvent = new PlayerCreated(nickname);
//        when(eventRepository.findEventsByAggregateId(aggregateId)).thenReturn(Flux.just(playerCreatedEvent));
//
//        // Act
//        Mono<PlayerResponse> result = useCase.execute(request);
//
//        // Assert
//        StepVerifier.create(result)
//                .expectNextMatches(response -> response.getPlayerId().equals(aggregateId))
//                .verifyComplete();
//
//        Mockito.verify(eventRepository).save(any(CardPlayed.class));
//    }
//
//}