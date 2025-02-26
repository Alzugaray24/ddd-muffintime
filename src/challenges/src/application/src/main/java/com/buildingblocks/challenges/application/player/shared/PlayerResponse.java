package com.buildingblocks.challenges.application.player.shared;

import com.buildingblocks.challenges.domain.card.Card;

import java.util.List;

public class PlayerResponse {

    private String playerId;
    private String nickname;
    private List<Card> cards;

    public PlayerResponse(String playerId, String nickname, List<Card> cards) {
        this.playerId = playerId;
        this.nickname = nickname;
        this.cards = cards;
    }



    public String getPlayerId() {
        return playerId;
    }

    public String getNickname() {
        return nickname;
    }


    public List<Card> getCards() {
        return cards;
    }


}
