package com.buildingblocks.challenges.domain.player.values;

import com.buildingblocks.shared.domain.generic.Identity;

public class ActionHistoryId extends Identity {
    public ActionHistoryId() {
        super();
    }

    private ActionHistoryId(String value) {
        super(value);
    }

    public static ActionHistoryId of(String value) {
        return new ActionHistoryId(value);
    }
}