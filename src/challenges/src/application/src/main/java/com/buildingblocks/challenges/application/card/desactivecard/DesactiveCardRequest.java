package com.buildingblocks.challenges.application.card.desactivecard;

import com.buildingblocks.shared.application.Request;

public class DesactiveCardRequest extends Request {

    private final String cardId;

    public DesactiveCardRequest(String aggregateId, String cardId) {
        super(aggregateId);
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }
}