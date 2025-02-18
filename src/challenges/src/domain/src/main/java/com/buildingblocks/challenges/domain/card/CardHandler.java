package com.buildingblocks.challenges.domain.card;

import com.buildingblocks.challenges.domain.card.events.CardActivated;
import com.buildingblocks.challenges.domain.card.events.CardDeactivated;
import com.buildingblocks.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.util.function.Consumer;

public class CardHandler extends DomainActionsContainer {

    private final Card card;

    public CardHandler(Card card) {
        this.card = card;
    }

    public Consumer<? extends DomainEvent> activeCard() {
        return (CardActivated event) -> {
            if (card.getActive().getValue()) {
                throw new IllegalArgumentException("Card already active");
            } else {
                if (card.getEffect().getDuration().getValue() > 0) {
                    card.activate();
                    card.getEffect().activate();
                    card.getReward().giveReward();
                } else {
                    throw new IllegalArgumentException("Card effect duration is 0");
                }
            }
        };
    }

    public Consumer<? extends DomainEvent> deactivateCard() {
        return (CardDeactivated event) -> {
            if(!card.getActive().getValue()){
                throw new IllegalArgumentException("Card already deactivated");
            } else {
                card.deactivate();
                card.getEffect().deactivate();
                card.getReward().deactivate();
            }
        };
    }


}
