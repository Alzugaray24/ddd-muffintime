// PlayerCardDrawn.java
package com.buildingblocks.challenges.domain.player.events;

import com.buildingblocks.challenges.domain.card.Card;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class CardDrawn extends DomainEvent {
    private final Card cardId;

    public CardDrawn(Card cardId) {
        super(EventsEnum.PLAYER_CARD_DRAWN.name());
        this.cardId = cardId;
    }

    public Card getCardId() {
        return cardId;
    }
}