package com.buildingblocks.challenges.domain.card.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class Description implements IValueObject {

    private final String value;

    private Description(String value) {
        this.value = value;
        validate();
    }

    public static Description of(String value) {
        return new Description(value);
    }


    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(value, "Description text cannot be empty");
    }

    public String getValue() {
        return value;
    }
}
