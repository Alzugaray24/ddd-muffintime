package com.buildingblocks.challenges.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class Number implements IValueObject {

    private final Integer value;

    private Number(Integer value) {
        validate();
        this.value = value;
    }

    public static Number of(Integer value) {
        return new Number(value);
    }

    @Override
    public void validate() {
        ValidationUtils.validateNumberNotNull(value, "Number value cannot be null");
        ValidationUtils.validateNumberNotNegative(value, "Number value cannot be negative");
    }

    public Integer getValue() {
        return value;
    }
}