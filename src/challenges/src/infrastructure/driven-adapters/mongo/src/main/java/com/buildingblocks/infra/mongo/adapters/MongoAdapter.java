package com.buildingblocks.infra.mongo.adapters;

import com.buildingblocks.challenges.application.shared.ports.IEventRepositoryPort;
import com.buildingblocks.infra.mongo.entities.Event;
import com.buildingblocks.infra.mongo.repositories.IEventsRepository;
import com.buildingblocks.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;

public class MongoAdapter implements IEventRepositoryPort {

    private final IEventsRepository eventsRepository;


    public MongoAdapter(IEventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }


    @Override
    public Flux<DomainEvent> findAllAgregates() {
        return eventsRepository.findAll().map(Event::getDomainEvent);
    }

    @Override
    public Flux<DomainEvent> findEventsByAggregateId(String aggregateId) {
        return findAllAgregates().filter(event -> event.getAggregateRootId().equals(aggregateId));
    }

    @Override
    public void save(DomainEvent domainEvent) {
        eventsRepository.save(new Event(domainEvent)).subscribe();
    }
}
