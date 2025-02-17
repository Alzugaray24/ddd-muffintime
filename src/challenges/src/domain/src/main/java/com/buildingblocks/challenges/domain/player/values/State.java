package com.buildingblocks.challenges.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class State implements IValueObject {

    private final String status;

    private State(String status) {
        validate();
        this.status = status;
    }

    public static State of(String status) {
        return new State(status);
    }

    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(status, "State status cannot be empty");
    }

    public String getStatus() {
        return status;
    }
}