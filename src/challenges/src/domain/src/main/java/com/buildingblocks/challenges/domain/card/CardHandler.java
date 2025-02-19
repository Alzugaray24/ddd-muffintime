// CardHandler.java
package com.buildingblocks.challenges.domain.card;

import com.buildingblocks.challenges.domain.card.events.CardActivated;
import com.buildingblocks.challenges.domain.card.events.CardDeactivated;

import com.buildingblocks.challenges.domain.card.values.IsActive;
import com.buildingblocks.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.util.function.Consumer;

public class CardHandler extends DomainActionsContainer {

    public CardHandler(Card card) {
        add(activateCard(card));
        add(deactivateCard(card));
    }

    private Consumer<? super DomainEvent> activateCard(Card card) {
        return (DomainEvent event) -> {
            if (event instanceof CardActivated) {
                if (card.getActive().getValue()) {
                    throw new IllegalArgumentException("Card already active");
                } else {
                    card.setActive(IsActive.of(true));
                }
            }
        };
    }

    private Consumer<? super DomainEvent> deactivateCard(Card card) {
        return (DomainEvent event) -> {
            if (event instanceof CardDeactivated) {
                if (!card.getActive().getValue()) {
                    throw new IllegalArgumentException("Card already deactivated");
                } else {
                    card.setActive(IsActive.of(false));
                }
            }
        };
    }
}