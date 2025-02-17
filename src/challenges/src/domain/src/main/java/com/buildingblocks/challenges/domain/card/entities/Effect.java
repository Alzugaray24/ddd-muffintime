package com.buildingblocks.challenges.domain.card.entities;

import com.buildingblocks.challenges.domain.card.values.*;
import com.buildingblocks.shared.domain.generic.Entity;

public class Effect extends Entity<EffectId> {

    private Title name;
    private Description description;
    private Type type;
    private IsActive active;

    public Effect(EffectId identity, Title name, Description description, Type type) {
        super(identity);
        this.name = name;
        this.description = description;
        this.type = type;
        this.active = IsActive.of(true);
    }

    public Effect(Title name, Description description, Type type) {
        super(new EffectId());
        this.name = name;
        this.description = description;
        this.type = type;
        this.active = IsActive.of(true);
    }

    public Title getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public boolean isActive() {
        return active.getValue();
    }

    public void setName(Title name) {
        this.name = name;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void applyEffect() {
        this.active = IsActive.of(true);
    }

    public void removeEffect() {
        this.active = IsActive.of(false);
    }

    public boolean isEffectActive() {
        return active.getValue();
    }
}