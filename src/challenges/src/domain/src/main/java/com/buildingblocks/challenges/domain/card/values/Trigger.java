package com.buildingblocks.challenges.domain.card.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class Trigger implements IValueObject {

    private final String value;

    private Trigger(String value) {
        this.value = value;
        validate();

    }

    public static Trigger of(String value) {
        return new Trigger(value);
    }

    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(value, "Trigger condition cannot be empty");

    }

    public String getValue() {
        return value;
    }
}