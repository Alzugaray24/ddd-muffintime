package com.buildingblocks.challenges.domain.card.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class ConditionActivated extends DomainEvent {
    private final String cardId;
    private final String conditionDetails;

    public ConditionActivated(String cardId, String conditionDetails) {
        super(EventsEnum.ACTIVATION_CONDITION_MET.name());
        this.cardId = cardId;
        this.conditionDetails = conditionDetails;
    }

    public String getCardId() {
        return cardId;
    }

    public String getConditionDetails() {
        return conditionDetails;
    }
}