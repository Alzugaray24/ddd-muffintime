// DesactiveCardUseCase.java
package com.buildingblocks.challenges.application.card.desactivecard;

import com.buildingblocks.challenges.application.card.shared.CardMapper;
import com.buildingblocks.challenges.application.card.shared.CardResponse;
import com.buildingblocks.challenges.application.shared.ports.IEventRepositoryPort;
import com.buildingblocks.challenges.domain.card.Card;
import com.buildingblocks.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class DesactiveCardUseCase implements ICommandUseCase<DesactiveCardRequest, Mono<CardResponse>> {

    private final IEventRepositoryPort eventRepository;

    public DesactiveCardUseCase(IEventRepositoryPort eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Mono<CardResponse> execute(DesactiveCardRequest request) {
        return eventRepository.findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .flatMap(events -> {
                    Card card = Card.from(request.getAggregateId(), events);
                    card.deactivateCard(request.getCardId());
                    card.getUncommittedEvents().forEach(eventRepository::save);
                    card.markEventsAsCommitted();
                    return Mono.just(CardMapper.toResponse(card));
                });
    }
}