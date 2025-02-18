package com.buildingblocks.challenges.domain.card.entities;

import com.buildingblocks.challenges.domain.card.values.*;
import com.buildingblocks.shared.domain.generic.Entity;

public class Reward extends Entity<RewardId> {

    private Description description;
    private TypeReward type;
    private IsActive active;
    private Trigger trigger;


    public Reward(RewardId identity, Description description, TypeReward type, IsActive active, Trigger trigger) {
        super(identity);
        this.description = description;
        this.type = type;
        this.active = active;
        this.trigger = trigger;
    }

    public Reward(Description description, TypeReward type, IsActive active, Trigger trigger) {
        super(new RewardId());
        this.description = description;
        this.type = type;
        this.active = active;
        this.trigger = trigger;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public TypeReward getType() {
        return type;
    }

    public void setType(TypeReward type) {
        this.type = type;
    }

    public IsActive getActive() {
        return active;
    }

    public void setActive(IsActive active) {
        this.active = active;
    }

    public void activate() {
        this.active = IsActive.of(true);
    }

    public void deactivate() {
        this.active = IsActive.of(false);
    }

    public Trigger getTrigger() {
        return trigger;
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }

    public void giveReward() {
        if (!active.getValue()) {
            throw new IllegalStateException("Reward is not active");
        }

        switch (type) {
            case CARTA_EXTRA:
                System.out.println("You have earned an extra card");
                break;
            case GANAR_MUFFINS:
                System.out.println("You have earned " + trigger.getAction() + " muffins");
                break;
            case VICTORIA_INSTANTANEA:
                System.out.println("You have won instantly");
                break;
            default:
                throw new IllegalArgumentException("Invalid reward type");
        }
    }


}
