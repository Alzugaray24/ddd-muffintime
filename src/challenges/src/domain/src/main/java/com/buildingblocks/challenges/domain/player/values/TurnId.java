package com.buildingblocks.challenges.domain.player.values;

import com.buildingblocks.shared.domain.generic.Identity;

public class TurnId extends Identity {
    public TurnId() {
        super();
    }

    private TurnId(String value) {
        super(value);
    }

    public static TurnId of(String value) {
        return new TurnId(value);
    }
}