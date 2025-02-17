package com.buildingblocks.challenges.domain.card.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class CardActivated extends DomainEvent {
    private final String cardId;

    public CardActivated(String cardId) {
        super(EventsEnum.CARD_ACTIVATED.name());
        this.cardId = cardId;

    }

    public String getCardId() {
        return cardId;
    }

}