// ActiveCardUseCase.java
package com.buildingblocks.challenges.application.card.activecard;

import com.buildingblocks.challenges.application.card.shared.CardMapper;
import com.buildingblocks.challenges.application.card.shared.CardResponse;
import com.buildingblocks.challenges.application.shared.ports.IEventRepositoryPort;
import com.buildingblocks.challenges.domain.card.Card;
import com.buildingblocks.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class ActiveCardUseCase implements ICommandUseCase<ActiveCardRequest, Mono<CardResponse>>  {

    private final IEventRepositoryPort eventRepository;

    public ActiveCardUseCase(IEventRepositoryPort eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Mono<CardResponse> execute(ActiveCardRequest request) {
        return eventRepository.findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .flatMap(events -> {
                    Card card = Card.from(request.getAggregateId(), events);
                    card.activateCard(request.getCardId());
                    card.getUncommittedEvents().forEach(eventRepository::save);
                    card.markEventsAsCommitted();
                    return Mono.just(CardMapper.toResponse(card));
                });
    }
}