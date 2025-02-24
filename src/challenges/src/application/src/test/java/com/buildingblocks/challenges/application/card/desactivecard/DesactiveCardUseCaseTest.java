// DesactiveCardUseCaseTest.java
package com.buildingblocks.challenges.application.card.desactivecard;

import com.buildingblocks.challenges.application.shared.IEventRepository;
import com.buildingblocks.challenges.domain.card.events.CardActivated;
import com.buildingblocks.challenges.domain.card.events.CardDeactivated;
import com.buildingblocks.shared.domain.generic.DomainEvent;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class DesactiveCardUseCaseTest {

    private final IEventRepository eventRepository = Mockito.mock(IEventRepository.class);
    private final DesactiveCardUseCase useCase = new DesactiveCardUseCase(eventRepository);

    @Test
    void executeSuccess() {
        // Arrange
        String aggregateId = "card-123";
        String cardId = "card-123";
        DesactiveCardRequest request = new DesactiveCardRequest(aggregateId, cardId);
        DomainEvent cardActivatedEvent = new CardActivated(cardId);
        when(eventRepository.findEventsByAggregateId(aggregateId)).thenReturn(Flux.just(cardActivatedEvent));

        // Act
        Mono<Void> result = useCase.execute(request);

        // Assert
        StepVerifier.create(result)
                .verifyComplete();

        Mockito.verify(eventRepository).save(any(CardDeactivated.class));
    }

    @Test
    void executeCardAlreadyDeactivated() {
        // Arrange
        String aggregateId = "card-123";
        String cardId = "card-123";
        DesactiveCardRequest request = new DesactiveCardRequest(aggregateId, cardId);
        DomainEvent cardDeactivatedEvent = new CardDeactivated(cardId);
        when(eventRepository.findEventsByAggregateId(aggregateId)).thenReturn(Flux.just(cardDeactivatedEvent));

        // Act
        Mono<Void> result = useCase.execute(request);

        // Assert
        StepVerifier.create(result)
                .expectError(IllegalArgumentException.class)
                .verify();

        Mockito.verify(eventRepository, Mockito.never()).save(any(CardDeactivated.class));
    }
}