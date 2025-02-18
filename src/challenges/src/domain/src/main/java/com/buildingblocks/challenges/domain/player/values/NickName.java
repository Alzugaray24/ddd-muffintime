package com.buildingblocks.challenges.domain.player.values;


import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class NickName implements IValueObject {

    private final String name;

    private NickName(String name) {
        validate();
        this.name = name;
    }

    public static NickName of(String name) {
        return new NickName(name);
    }

    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(name, "Action name cannot be empty");
    }

    public String getName() {
        return name;
    }

}
