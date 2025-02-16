package com.buildingblocks.challenges.domain.card.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class EffectFailed extends DomainEvent {
    private final String effectId;

    public EffectFailed(String effectId) {
        super(EventsEnum.EFFECT_FAILED.name());
        this.effectId = effectId;
    }

    public String getEffectId() {
        return effectId;
    }
}