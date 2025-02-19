// PlayerStateChanged.java
package com.buildingblocks.challenges.domain.player.events;

import com.buildingblocks.challenges.domain.player.values.State;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class PlayerStateChanged extends DomainEvent {
    private final State newState;

    public PlayerStateChanged(State newState) {
        super(EventsEnum.PLAYER_STATE_CHANGED.name());
        this.newState = newState;
    }

    public State getNewState() {
        return newState;
    }
}