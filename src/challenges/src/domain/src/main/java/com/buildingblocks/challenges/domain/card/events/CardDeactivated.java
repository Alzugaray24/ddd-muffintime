package com.buildingblocks.challenges.domain.card.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class CardDeactivated extends DomainEvent {
    private final String cardId;

    public CardDeactivated(String cardId) {
        super(EventsEnum.CARD_DEACTIVATED.name());
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }
}