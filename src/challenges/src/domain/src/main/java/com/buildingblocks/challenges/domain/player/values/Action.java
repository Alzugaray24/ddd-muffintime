package com.buildingblocks.challenges.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class Action implements IValueObject {

    private final String name;
    private final String description;

    private Action(String name, String description) {
        validate();
        this.name = name;
        this.description = description;
    }

    public static Action of(String name, String description) {
        return new Action(name, description);
    }

    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(name, "Action name cannot be empty");
        ValidationUtils.validateTextNotEmpty(description, "Action description cannot be empty");
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}