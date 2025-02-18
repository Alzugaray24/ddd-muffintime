package com.buildingblocks.challenges.domain.card.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class Amount implements IValueObject {

    private final int value;

    private Amount(int value) {
        validate();
        this.value = value;
    }

    public static Amount of(int value) {
        return new Amount(value);
    }

    @Override
    public void validate() {
        ValidationUtils.validateNumberNotNegative(value, "Amount value must be positive");
    }

    public int getValue() {
        return value;
    }
}