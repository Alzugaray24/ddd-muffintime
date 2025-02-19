package com.buildingblocks.challenges.domain.card.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;


public class Duration implements IValueObject {

    private final Integer value;

    private Duration(Integer value) {
        this.value = value;
        validate();
    }

    public static Duration of(Integer value) {
        return new Duration(value);
    }

    @Override
    public void validate() {
        ValidationUtils.validateNumberNotNegative(value, "Duration value cannot be negative");
    }

    public Integer getValue() {
        return value;
    }
}