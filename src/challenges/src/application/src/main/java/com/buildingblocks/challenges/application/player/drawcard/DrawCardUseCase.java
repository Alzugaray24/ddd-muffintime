// DrawCardUseCase.java
package com.buildingblocks.challenges.application.player.drawcard;

import com.buildingblocks.challenges.application.shared.IEventRepository;
import com.buildingblocks.challenges.application.shared.PlayerMapper;
import com.buildingblocks.challenges.application.shared.PlayerResponse;
import com.buildingblocks.challenges.domain.player.Player;
import com.buildingblocks.challenges.domain.player.values.NickName;
import com.buildingblocks.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class DrawCardUseCase implements ICommandUseCase<DrawCardRequest, Mono<PlayerResponse>> {

    private final IEventRepository eventRepository;

    public DrawCardUseCase(IEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Mono<PlayerResponse> execute(DrawCardRequest request) {
        return eventRepository.findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Player player = Player.from(request.getAggregateId(), events);
                    if (player.getNickName() == null) {
                        player.setNickName(NickName.of(request.getNickname()));
                    }
                    player.drawnCard(request.getCardId());
                    player.getUncommittedEvents().forEach(eventRepository::save);
                    return PlayerMapper.toResponse(player);
                });
    }
}