package com.buildingblocks.challenges.application.player.playcard;

import com.buildingblocks.shared.application.Request;

public class PlayCardRequest extends Request{

    private String cardId;


    public PlayCardRequest(String aggregateId, String cardId) {
        super(aggregateId);
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }

}

