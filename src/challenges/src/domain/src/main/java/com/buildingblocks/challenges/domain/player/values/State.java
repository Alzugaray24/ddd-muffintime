// State.java
package com.buildingblocks.challenges.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class State implements IValueObject {

    private final StateEnum value;

    private State(StateEnum value) {
        this.value = value;
        validate();
    }

    public static State of(StateEnum value) {
        return new State(value);
    }

    @Override
    public void validate() {
        System.out.println("StateEnum: " + value);
        ValidationUtils.validateBoolean(value != null, "State cannot be null");
    }

    public StateEnum getValue() {
        return value;
    }
}