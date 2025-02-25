package com.buildingblocks.challenges.application.player.playcard;

import com.buildingblocks.shared.application.Request;

public class PlayCardRequest extends Request{

    private final String cardId;
    private final String action;
    private final String playerId;
    private final String nickname;


    public PlayCardRequest(String aggregateId, String cardId, String action, String playerId, String nickname) {
        super(aggregateId);
        this.cardId = cardId;
        this.action = action;
        this.playerId = playerId;
        this.nickname = nickname;
    }

    public String getCardId() {
        return cardId;
    }

    public String getAction() {
        return action;
    }

    public String getNickname() {
        return nickname;
    }

}

