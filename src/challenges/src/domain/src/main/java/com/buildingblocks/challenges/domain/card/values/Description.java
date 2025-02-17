package com.buildingblocks.challenges.domain.card.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class Description implements IValueObject {

    private final String text;
    private final String flavorText;

    private Description(String text, String flavorText) {
        validate();
        this.text = text;
        this.flavorText = flavorText;
    }

    public static Description of(String text, String flavorText) {
        return new Description(text, flavorText);
    }


    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(text, "Description text cannot be empty");
        ValidationUtils.validateTextNotEmpty(flavorText, "Description flavor text cannot be empty");
    }

    public String getText() {
        return text;
    }

    public String getFlavorText() {
        return flavorText;
    }
}
