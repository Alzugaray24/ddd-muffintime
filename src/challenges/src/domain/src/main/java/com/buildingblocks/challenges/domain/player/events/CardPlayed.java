// PlayerCardPlayed.java
package com.buildingblocks.challenges.domain.player.events;

import com.buildingblocks.challenges.domain.card.Card;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class CardPlayed extends DomainEvent {
    private final Card cardId;

    public CardPlayed(Card cardId) {
        super(EventsEnum.PLAYER_CARD_PLAYED.name());
        this.cardId = cardId;
    }

    public Card getCardId() {
        return cardId;
    }
}