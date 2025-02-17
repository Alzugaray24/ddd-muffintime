package com.buildingblocks.challenges.domain.card.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class EffectDeactivated extends DomainEvent {
    private final String effectId;

    public EffectDeactivated(String effectId) {
        super(EventsEnum.EFFECT_FAILED.name());
        this.effectId = effectId;
    }

    public String getEffectId() {
        return effectId;
    }
}