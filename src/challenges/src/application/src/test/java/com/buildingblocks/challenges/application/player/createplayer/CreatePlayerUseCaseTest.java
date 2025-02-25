//package com.buildingblocks.challenges.application.player.createplayer;
//
//import com.buildingblocks.challenges.application.shared.ports.IEventRepositoryPort;
//import com.buildingblocks.challenges.application.player.shared.PlayerResponse;
//import com.buildingblocks.challenges.domain.player.events.PlayerCreated;
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
//class CreatePlayerUseCaseTest {
//
//    private final CreatePlayerUseCase useCase;
//    private final IEventRepositoryPort eventRepository;
//
//    public CreatePlayerUseCaseTest() {
//        eventRepository = Mockito.mock(IEventRepositoryPort.class);
//        this.useCase = new CreatePlayerUseCase(eventRepository);
//    }
//
//    @Test
//    void executeSuccess() {
//        // Arrange
//        String aggregateId = "player-123";
//        String nickname = "testPlayer";
//        CreatePlayerRequest request = new CreatePlayerRequest(nickname);
//        when(eventRepository.findEventsByAggregateId(aggregateId)).thenReturn(Flux.fromIterable(Collections.emptyList()));
//
//        // Act
//        Mono<PlayerResponse> result = useCase.execute(request);
//
//        // Assert
//        StepVerifier.create(result)
//                .expectNextMatches(response -> response.getPlayerId().equals(aggregateId) )
//                .verifyComplete();
//
//        Mockito.verify(eventRepository).save(any(PlayerCreated.class));
//    }
//}