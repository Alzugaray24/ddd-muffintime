package com.buildingblocks.challenges.domain.card.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class Addressee implements IValueObject {

    private final String name;

    private Addressee(String name) {
        validate();
        this.name = name;
    }

    public static Addressee of(String name) {
        return new Addressee(name);
    }


    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(name, "Addressee name cannot be empty");
    }

    public String getName() {
        return name;
    }
}
