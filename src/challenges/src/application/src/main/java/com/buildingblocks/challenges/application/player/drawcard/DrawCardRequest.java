package com.buildingblocks.challenges.application.player.drawcard;

import com.buildingblocks.shared.application.Request;

public class DrawCardRequest extends Request {
    private final String cardId;
    private final String nickname;

    public DrawCardRequest(String aggregateId, String cardId, String nickname) {
        super(aggregateId);
        this.cardId = cardId;
        this.nickname = nickname;

    }

    public String getCardId() {
        return cardId;
    }

    public String getNickname() {
        return nickname;
    }
}
