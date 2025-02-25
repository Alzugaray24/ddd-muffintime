package com.buildingblocks.challenges.application.shared.ports;

import com.buildingblocks.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;

public interface IEventRepositoryPort {

    Flux<DomainEvent> findAllAgregates();
    Flux<DomainEvent> findEventsByAggregateId(String aggregateId);
    void save(DomainEvent domainEvent);
}
