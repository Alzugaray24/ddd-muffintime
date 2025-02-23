package com.buildingblocks.challenges.application.player.createplayer;

import com.buildingblocks.shared.application.Request;

public class CreatePlayerRequest extends Request {

    private final String nickname;

    public CreatePlayerRequest(String aggregateId, String nickname) {
        super(aggregateId);
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
}