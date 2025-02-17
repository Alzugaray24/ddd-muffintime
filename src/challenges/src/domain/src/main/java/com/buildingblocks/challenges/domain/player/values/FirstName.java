package com.buildingblocks.challenges.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class FirstName implements IValueObject {

    private final String name;

    private FirstName(String name) {
        validate();
        this.name = name;
    }

    public static FirstName of(String name) {
        return new FirstName(name);
    }

    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(name, "First name cannot be empty");
    }

    public String getName() {
        return name;
    }
}