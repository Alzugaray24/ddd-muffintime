// PlayerActionRecorded.java
package com.buildingblocks.challenges.domain.player.events;

import com.buildingblocks.challenges.domain.player.values.Action;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class PlayerActionRecorded extends DomainEvent {
    private final Action action;

    public PlayerActionRecorded(Action action) {
        super(EventsEnum.PLAYER_ACTION_RECORDED.name());
        this.action = action;
    }

    public Action getAction() {
        return action;
    }
}