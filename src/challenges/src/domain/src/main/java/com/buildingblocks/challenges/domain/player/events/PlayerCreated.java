// PlayerCreated.java
package com.buildingblocks.challenges.domain.player.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class PlayerCreated extends DomainEvent {
    private final String playerId;
    private final String nickName;

    public PlayerCreated(String playerId, String nickName) {
        super(EventsEnum.PLAYER_CREATED.name());
        this.playerId = playerId;
        this.nickName = nickName;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getNickName() {
        return nickName;
    }
}