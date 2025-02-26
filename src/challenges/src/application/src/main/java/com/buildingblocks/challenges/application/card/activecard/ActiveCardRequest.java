package com.buildingblocks.challenges.application.card.activecard;

import com.buildingblocks.shared.application.Request;

public class ActiveCardRequest extends Request {

    private String cardId;

    public ActiveCardRequest(String aggregateId, String cardId) {
        super(aggregateId);
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }
}