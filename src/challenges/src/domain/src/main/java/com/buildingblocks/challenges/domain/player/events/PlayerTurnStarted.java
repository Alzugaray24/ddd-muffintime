package com.buildingblocks.challenges.domain.player.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class PlayerTurnStarted extends DomainEvent {

        private final String playerId;

        public PlayerTurnStarted( String playerId) {
            super(EventsEnum.PLAYER_TURN_STARTED.name());
            this.playerId = playerId;
        }

        public String getPlayerId() {
            return playerId;
        }
}
