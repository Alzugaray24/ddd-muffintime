package com.buildingblocks.challenges.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class Action implements IValueObject {

    private final String value;

    private Action(String value) {
        this.value = value;
        validate();
    }

    public static Action of(String value) {
        return new Action(value);
    }

    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(this.value, "Action cannot be empty");
    }

    public String getValue() {
        return value;
    }
}