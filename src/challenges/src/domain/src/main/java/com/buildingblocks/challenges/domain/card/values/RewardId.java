package com.buildingblocks.challenges.domain.card.values;

import com.buildingblocks.shared.domain.generic.Identity;

public class RewardId extends Identity {
    public RewardId() {
        super();
    }

    private RewardId(String value) {
        super(value);
    }

    public static RewardId of(String value) {
        return new RewardId(value);
    }
}
