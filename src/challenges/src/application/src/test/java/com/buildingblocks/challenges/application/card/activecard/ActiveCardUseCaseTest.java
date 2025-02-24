// ActiveCardUseCaseTest.java
package com.buildingblocks.challenges.application.card.activecard;

import com.buildingblocks.challenges.application.shared.IEventRepository;
import com.buildingblocks.challenges.domain.card.events.CardActivated;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ActiveCardUseCaseTest {

    private final IEventRepository eventRepository = Mockito.mock(IEventRepository.class);
    private final ActiveCardUseCase useCase = new ActiveCardUseCase(eventRepository);

    @Test
    void executeSuccess() {
        // Arrange
        String aggregateId = "card-123";
        String cardId = "card-123";
        ActiveCardRequest request = new ActiveCardRequest(aggregateId, cardId);
        when(eventRepository.findEventsByAggregateId(aggregateId)).thenReturn(Flux.fromIterable(Collections.emptyList()));

        // Act
        Mono<Void> result = useCase.execute(request);

        // Assert
        StepVerifier.create(result)
                .verifyComplete();

        Mockito.verify(eventRepository).save(any(CardActivated.class));
    }
}