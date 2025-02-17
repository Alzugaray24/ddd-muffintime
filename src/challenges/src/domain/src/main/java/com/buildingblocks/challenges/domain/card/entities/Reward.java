package com.buildingblocks.challenges.domain.card.entities;

import com.buildingblocks.challenges.domain.card.values.*;
import com.buildingblocks.shared.domain.generic.Entity;

public class Reward extends Entity<RewardId> {

    private Title title;
    private Description description;
    private IsActive isActive;
    private Value value;

    public Reward(RewardId identity, Title title, Description description, IsActive isActive, Value value) {
        super(identity);
        this.title = title;
        this.description = description;
        this.isActive = isActive;
        this.value = value;
    }

    public Reward(Title title, Description description, IsActive isActive, Value value) {
        super(new RewardId());
        this.title = title;
        this.description = description;
        this.isActive = isActive;
        this.value = value;
    }

    public Title getTitle() {
        return title;
    }

    public Description getDescription() {
        return description;
    }

    public IsActive getIsActive() {
        return isActive;
    }

    public Value getValue() {
        return value;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public void setIsActive(IsActive isActive) {
        this.isActive = isActive;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public void activateReward() {
        this.isActive = IsActive.of(true);
    }

    public void deactivateReward() {
        this.isActive = IsActive.of(false);
    }
}