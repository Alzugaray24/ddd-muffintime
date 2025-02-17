package com.buildingblocks.challenges.domain.card.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class State implements IValueObject {

    private final String status;
    private final String details;

    private State(String status, String details) {
        validate();
        this.status = status;
        this.details = details;
    }

    public static State of(String status, String details) {
        return new State(status, details);
    }

    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(status, "State status cannot be empty");
        ValidationUtils.validateTextNotEmpty(details, "State details cannot be empty");
    }

    public String getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }
}