package com.buildingblocks.challenges.domain.card.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class Type implements IValueObject {

    private final TypeEffect value;

    private Type(TypeEffect value) {
        this.value = value;
        validate();
    }

    public static Type of( TypeEffect value) {
        return new Type(value);
    }

    @Override
    public void validate() {
        ValidationUtils.validateBoolean(value != null, "State cannot be null");
    }

    public TypeEffect getValue() {
        return value;
    }
}
