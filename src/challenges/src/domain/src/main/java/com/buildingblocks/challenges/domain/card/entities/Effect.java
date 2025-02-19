// Effect.java
package com.buildingblocks.challenges.domain.card.entities;

import com.buildingblocks.challenges.domain.card.values.*;
import com.buildingblocks.challenges.domain.player.values.IsActive;
import com.buildingblocks.shared.domain.generic.Entity;


public class Effect extends Entity<EffectId> {

    private Title name;
    private Description description;
    private TypeEffect type;
    private Duration duration;
    private IsActive active;

    public Effect(EffectId identity, Title name, Description description, TypeEffect type, Duration duration, IsActive active) {
        super(identity);
        this.name = name;
        this.description = description;
        this.type = type;
        this.duration = duration;
        this.active = active;
    }

    public Effect(Title name, Description description, TypeEffect type, Duration duration, IsActive active) {
        super(new EffectId());
        this.name = name;
        this.description = description;
        this.type = type;
        this.duration = duration;
        this.active = active;
    }

    public Title getName() {
        return name;
    }

    public void setName(Title name) {
        this.name = name;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public TypeEffect getType() {
        return type;
    }

    public void setType(TypeEffect type) {
        this.type = type;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public IsActive getActive() {
        return active;
    }

    public void setActive(IsActive active) {
        this.active = active;
    }
}