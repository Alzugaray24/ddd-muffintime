package com.buildingblocks.challenges.domain.card.entities;

import com.buildingblocks.challenges.domain.card.values.*;
import com.buildingblocks.shared.domain.generic.Entity;
import com.buildingblocks.challenges.domain.card.values.ActivationConditionId;

public class ActivationCondition extends  Entity<ActivationConditionId> {

    private Title title;
    private Description description;
    private IsActive isActive;
    private Trigger trigger;

    public ActivationCondition(ActivationConditionId identity, Title title, Description description, IsActive isActive, Trigger trigger) {
        super(identity);
        this.title = title;
        this.description = description;
        this.isActive = isActive;
        this.trigger = trigger;
    }

    public ActivationCondition(Title title, Description description, IsActive isActive, Trigger trigger) {
        super(new ActivationConditionId());
        this.title = title;
        this.description = description;
        this.isActive = isActive;
        this.trigger = trigger;
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

    public Trigger getTrigger() {
        return trigger;
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

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }

    public void activateCondition() {
        this.isActive = IsActive.of(true);
    }

    public void deactivateCondition() {
        this.isActive = IsActive.of(false);
    }
}