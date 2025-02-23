package com.buildingblocks.challenges.application.shared;

public class PlayerResponse {

    private final String playerId;
//    private final String nickname;

    public PlayerResponse(String playerId, String nickname) {
        this.playerId = playerId;
//        this.nickname = nickname;
    }


    public String getPlayerId() {
        return playerId;
    }





}
