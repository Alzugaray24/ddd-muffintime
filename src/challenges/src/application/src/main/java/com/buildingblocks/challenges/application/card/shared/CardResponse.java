package com.buildingblocks.challenges.application.card.shared;

public class CardResponse {

    private final String cardId;

    public CardResponse(String cardId) {
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }

}