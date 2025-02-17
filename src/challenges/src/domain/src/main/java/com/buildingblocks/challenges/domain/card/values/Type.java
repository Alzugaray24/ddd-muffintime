package com.buildingblocks.challenges.domain.card.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class Type implements IValueObject {

    private final String name;

    private Type(String name) {
        validate();
        this.name = name;
    }

    public static Type of(String name) {
        return new Type(name);
    }

    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(name, "Type name cannot be empty");
    }

    public String getName() {
        return name;
    }
}