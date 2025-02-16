package com.buildingblocks.challenges.domain.card.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class EffectActivated extends DomainEvent {
    private final String effectId;

    public EffectActivated(String effectId) {
        super(EventsEnum.EFFECT_ACTIVATED.name());
        this.effectId = effectId;
    }

    public String getEffectId() {
        return effectId;
    }

}