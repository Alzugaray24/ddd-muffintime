package com.buildingblocks.challenges.domain.card.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class Trigger implements IValueObject {

    private final String condition;
    private final String action;

    private Trigger(String condition, String action) {
        validate();
        this.condition = condition;
        this.action = action;
    }

    public static Trigger of(String condition, String action) {
        return new Trigger(condition, action);
    }

    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(condition, "Trigger condition cannot be empty");
        ValidationUtils.validateTextNotEmpty(action, "Trigger action cannot be empty");
    }

    public String getCondition() {
        return condition;
    }

    public String getAction() {
        return action;
    }
}