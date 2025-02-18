package com.buildingblocks.challenges.domain.card.values;

import com.buildingblocks.shared.domain.generic.IValueObject;
import com.buildingblocks.shared.domain.utils.ValidationUtils;

public class Type implements IValueObject {

    private final String name;
    private final TypeEffect effect;
    private final TypeReward reward;

    private Type(String name, TypeEffect effect, TypeReward reward) {
        validate();
        this.name = name;
        this.effect = effect;
        this.reward = reward;
    }

    public static Type of(String name, TypeEffect effect, TypeReward reward) {
        return new Type(name, effect, reward);
    }

    @Override
    public void validate() {
        ValidationUtils.validateTextNotEmpty(name, "Type name cannot be empty");
    }

    public String getName() {
        return name;
    }

    public TypeEffect getEffect() {
        return effect;
    }

    public TypeReward getReward() {
        return reward;
    }
}
