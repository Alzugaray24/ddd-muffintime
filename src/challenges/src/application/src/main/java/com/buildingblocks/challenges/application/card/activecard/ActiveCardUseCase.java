// ActiveCardUseCase.java
package com.buildingblocks.challenges.application.card.activecard;

import com.buildingblocks.challenges.application.shared.IEventRepository;
import com.buildingblocks.challenges.domain.card.Card;
import com.buildingblocks.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class ActiveCardUseCase implements ICommandUseCase<ActiveCardRequest, Mono<Void>> {

    private final IEventRepository eventRepository;

    public ActiveCardUseCase(IEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Mono<Void> execute(ActiveCardRequest request) {
        return eventRepository.findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .flatMap(events -> {
                    Card card = Card.from(request.getAggregateId(), events);
                    card.activateCard(request.getCardId());
                    card.getUncommittedEvents().forEach(eventRepository::save);
                    return Mono.empty();
                });
    }
}