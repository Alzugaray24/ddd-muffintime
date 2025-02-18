package com.buildingblocks.challenges.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class State implements IValueObject {

    private final StateEnum status;

    private State(StateEnum status) {
        validate();
        this.status = status;
    }

    public static State of(StateEnum status) {
        return new State(status);
    }

    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(status.name(), "State cannot be null");
    }

    public StateEnum getStatus() {
        return status;
    }


}