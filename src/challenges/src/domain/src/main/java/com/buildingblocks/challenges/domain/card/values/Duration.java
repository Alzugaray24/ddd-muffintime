package com.buildingblocks.challenges.domain.card.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

import java.util.Arrays;
import java.util.List;

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
        ValidationUtils.validateNumberNotNegative(value, "La duración no puede estar vacía.");
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duration duration = (Duration) o;
        return value.equals(duration.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}