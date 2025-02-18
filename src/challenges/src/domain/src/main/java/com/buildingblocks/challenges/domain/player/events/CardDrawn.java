// PlayerCardDrawn.java
package com.buildingblocks.challenges.domain.player.events;

import com.buildingblocks.challenges.domain.card.Card;
import com.buildingblocks.shared.domain.generic.DomainEvent;

public class CardDrawn extends DomainEvent {
    private final String playerId;
    private final Card cardId;

    public CardDrawn(String playerId, Card cardId) {
        super(EventsEnum.PLAYER_CARD_DRAWN.name());
        this.playerId = playerId;
        this.cardId = cardId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public Card getCardId() {
        return cardId;
    }
}