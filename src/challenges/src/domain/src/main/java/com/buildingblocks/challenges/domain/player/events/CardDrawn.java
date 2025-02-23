// PlayerCardDrawn.java
package com.buildingblocks.challenges.domain.player.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class CardDrawn extends DomainEvent {
    private final String cardId;

    public CardDrawn(String cardId) {
        super(EventsEnum.PLAYER_CARD_DRAWN.name());
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }

}