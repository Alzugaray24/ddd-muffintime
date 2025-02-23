// PlayerCardPlayed.java
package com.buildingblocks.challenges.domain.player.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class CardPlayed extends DomainEvent {
    private final String cardId;
    private final String action;

    public CardPlayed(String cardId, String action) {
        super(EventsEnum.PLAYER_CARD_PLAYED.name());
        this.cardId = cardId;
        this.action = action;
    }

    public String getCardId() {
        return cardId;
    }

    public String getAction() {
        return action;
    }
}