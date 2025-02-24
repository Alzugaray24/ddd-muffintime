// DesactiveCardUseCase.java
package com.buildingblocks.challenges.application.card.desactivecard;

import com.buildingblocks.challenges.application.shared.IEventRepository;
import com.buildingblocks.challenges.domain.card.Card;
import com.buildingblocks.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class DesactiveCardUseCase implements ICommandUseCase<DesactiveCardRequest, Mono<Void>> {

    private final IEventRepository eventRepository;

    public DesactiveCardUseCase(IEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Mono<Void> execute(DesactiveCardRequest request) {
        return eventRepository.findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .flatMap(events -> {
                    Card card = Card.from(request.getAggregateId(), events);
                    card.deactivateCard(request.getCardId());
                    card.getUncommittedEvents().forEach(eventRepository::save);
                    return Mono.empty();
                });
    }
}