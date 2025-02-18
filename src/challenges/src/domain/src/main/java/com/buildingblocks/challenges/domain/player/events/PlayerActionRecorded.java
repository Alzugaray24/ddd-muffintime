// PlayerActionRecorded.java
package com.buildingblocks.challenges.domain.player.events;

import com.buildingblocks.challenges.domain.player.values.Action;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class PlayerActionRecorded extends DomainEvent {
    private final String playerId;
    private final Action action;

    public PlayerActionRecorded(String playerId, Action action) {
        super(EventsEnum.PLAYER_ACTION_RECORDED.name());
        this.playerId = playerId;
        this.action = action;
    }

    public String getPlayerId() {
        return playerId;
    }

    public Action getAction() {
        return action;
    }
}