package com.buildingblocks.challenges.domain.card.values;

import com.buildingblocks.shared.domain.generic.Identity;

public class EffectId extends Identity {
    public EffectId() {
        super();
    }

    private EffectId(String value) {
        super(value);
    }

    public static EffectId of(String value) {
        return new EffectId(value);
    }
}