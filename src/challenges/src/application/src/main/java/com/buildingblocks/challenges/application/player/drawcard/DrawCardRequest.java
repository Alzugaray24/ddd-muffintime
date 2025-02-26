package com.buildingblocks.challenges.application.player.drawcard;

import com.buildingblocks.shared.application.Request;

public class DrawCardRequest extends Request {
    private String cardId;

    public DrawCardRequest(String aggregateId, String cardId) {
        super(aggregateId);
        this.cardId = cardId;

    }

    public String getCardId() {
        return cardId;
    }

}
