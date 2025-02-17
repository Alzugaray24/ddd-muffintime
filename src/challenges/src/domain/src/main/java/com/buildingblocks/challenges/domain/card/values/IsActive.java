package com.buildingblocks.challenges.domain.card.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class IsActive implements IValueObject {

    private final boolean value;

    private IsActive(boolean value) {
        this.value = value;
        validate();
    }

    public static IsActive of(boolean value) {
        return new IsActive(value);
    }

    @Override
    public void validate() {
        ValidationUtils.validateBoolean(value, "IsActive value cannot be null");
    }

    public boolean getValue() {
        return value;
    }
}