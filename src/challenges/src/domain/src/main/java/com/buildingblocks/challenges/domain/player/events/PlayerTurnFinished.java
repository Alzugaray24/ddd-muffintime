package com.buildingblocks.challenges.domain.player.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class PlayerTurnFinished extends DomainEvent {

    private final String playerId;

    public PlayerTurnFinished( String playerId, String action) {
        super(EventsEnum.PLAYER_TURN_FINISHED.name());
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return playerId;
    }
}
