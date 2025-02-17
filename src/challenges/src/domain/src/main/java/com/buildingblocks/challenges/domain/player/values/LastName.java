package com.buildingblocks.challenges.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class LastName implements IValueObject {

    private final String name;

    private LastName(String name) {
        validate();
        this.name = name;
    }

    public static LastName of(String name) {
        return new LastName(name);
    }

    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(name, "Last name cannot be empty");
    }

    public String getName() {
        return name;
    }
}