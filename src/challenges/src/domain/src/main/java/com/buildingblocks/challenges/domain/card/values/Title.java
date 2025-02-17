package com.buildingblocks.challenges.domain.card.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class Title implements IValueObject {

    private final String text;

    private Title(String text) {
        validate();
        this.text = text;
    }

    public static Title of(String text) {
        return new Title(text);
    }

    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(text, "Title text cannot be empty");
    }

    public String getText() {
        return text;
    }
}