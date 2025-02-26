// PlayerCardPlayed.java
package com.buildingblocks.challenges.domain.player.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class CardPlayed extends DomainEvent {
    private final String cardId;

    public CardPlayed(String cardId) {
        super(EventsEnum.PLAYER_CARD_PLAYED.name());
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }

}