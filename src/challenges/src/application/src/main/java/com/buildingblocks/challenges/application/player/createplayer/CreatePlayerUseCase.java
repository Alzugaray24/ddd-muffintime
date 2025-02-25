package com.buildingblocks.challenges.application.player.createplayer;

import com.buildingblocks.challenges.application.shared.ports.IEventRepositoryPort;
import com.buildingblocks.challenges.application.player.shared.PlayerMapper;
import com.buildingblocks.challenges.application.player.shared.PlayerResponse;
import com.buildingblocks.challenges.domain.player.Player;
import com.buildingblocks.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class CreatePlayerUseCase implements ICommandUseCase<CreatePlayerRequest, Mono<PlayerResponse>> {

    private final IEventRepositoryPort eventRepository;

    public CreatePlayerUseCase(IEventRepositoryPort eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
        public Mono<PlayerResponse> execute(CreatePlayerRequest request) {
        return eventRepository.findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Player player = Player.from(request.getAggregateId(), events);
                    player.createPlayer(request.getNickname());
                    player.getUncommittedEvents().forEach(eventRepository::save);
                    player.markEventsAsCommitted();
                    return PlayerMapper.toResponse(player);
                });
        }
}
