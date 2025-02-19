package com.buildingblocks.challenges.domain.card.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class Title implements IValueObject {

    private final String value;

    private Title(String value) {
        this.value = value;
        validate();
    }

    public static Title of(String value) {
        return new Title(value);
    }

    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(value, "Title text cannot be empty");
    }

    public String getValue() {
        return value;
    }
}