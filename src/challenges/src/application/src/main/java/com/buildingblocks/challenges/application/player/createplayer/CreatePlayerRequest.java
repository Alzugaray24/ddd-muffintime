package com.buildingblocks.challenges.application.player.createplayer;

import com.buildingblocks.shared.application.Request;

public class CreatePlayerRequest extends Request {

    private String nickname;

    public CreatePlayerRequest(String nickname) {
        super(null);
        this.nickname = nickname;
    }

    public CreatePlayerRequest() {
        super(null);
    }

    public String getNickname() {
        return nickname;
    }
}