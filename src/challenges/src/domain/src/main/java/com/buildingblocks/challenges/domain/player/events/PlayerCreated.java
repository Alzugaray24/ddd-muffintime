// PlayerCreated.java
package com.buildingblocks.challenges.domain.player.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class PlayerCreated extends DomainEvent {
    private final String nickName;

    public PlayerCreated(String nickName) {
        super(EventsEnum.PLAYER_CREATED.name());
        this.nickName = nickName;
    }


    public String getNickName() {
        return nickName;
    }
}