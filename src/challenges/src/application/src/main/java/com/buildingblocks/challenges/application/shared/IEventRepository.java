package com.buildingblocks.challenges.application.shared;

import com.buildingblocks.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;

public interface IEventRepository {

    Flux<DomainEvent> findEventsByAggregateId(String aggregateId);
    void save(DomainEvent domainEvent);
}
