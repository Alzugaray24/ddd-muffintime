// PlayerStateChanged.java
package com.buildingblocks.challenges.domain.player.events;

import com.buildingblocks.challenges.domain.player.values.State;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class PlayerStateChanged extends DomainEvent {
    private final String playerId;
    private final State newState;

    public PlayerStateChanged(String playerId, State newState) {
        super(EventsEnum.PLAYER_STATE_CHANGED.name());
        this.playerId = playerId;
        this.newState = newState;
    }

    public String getPlayerId() {
        return playerId;
    }

    public State getNewState() {
        return newState;
    }
}