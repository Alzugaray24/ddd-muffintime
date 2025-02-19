// NickName.java
package com.buildingblocks.challenges.domain.player.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class NickName implements IValueObject {

    private final String value;

    private NickName(String value) {
        this.value = value;
        validate();
    }

    public static NickName of(String value) {
        return new NickName(value);
    }

    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(this.value, "Nickname cannot be empty");
    }

    public String getValue() {
        return value;
    }
}