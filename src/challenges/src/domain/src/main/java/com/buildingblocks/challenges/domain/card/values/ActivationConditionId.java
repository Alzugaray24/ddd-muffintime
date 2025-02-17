package com.buildingblocks.challenges.domain.card.values;

import com.buildingblocks.shared.domain.generic.Identity;

public class ActivationConditionId extends Identity {
    public ActivationConditionId() {
        super();
    }

    private ActivationConditionId(String value) {
        super(value);
    }

    public static ActivationConditionId of(String value) {
        return new ActivationConditionId(value);
    }
}
