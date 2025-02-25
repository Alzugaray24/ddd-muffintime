package com.buildingblocks.challenges.application.card.shared;

import com.buildingblocks.challenges.domain.card.Card;

public class CardMapper {

    public static CardResponse toResponse(Card card) {
        return new CardResponse(
                card.getIdentity().getValue()
        );
    }
}
