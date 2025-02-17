package com.buildingblocks.challenges.domain.card.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class Value implements IValueObject {

    private final String amount;
    private final String currency;

    private Value(String amount, String currency) {
        validate();
        this.amount = amount;
        this.currency = currency;
    }

    public static Value of(String amount, String currency) {
        return new Value(amount, currency);
    }

    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(amount, "Value amount cannot be empty");
        ValidationUtils.validateTextNotEmpty(currency, "Value currency cannot be empty");
    }

    public String getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}