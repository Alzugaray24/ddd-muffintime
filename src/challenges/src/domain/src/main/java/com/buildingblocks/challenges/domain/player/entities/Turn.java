// Turn.java
package com.buildingblocks.challenges.domain.player.entities;

import com.buildingblocks.challenges.domain.player.values.IsActive;
import com.buildingblocks.challenges.domain.player.values.TurnId;
import com.buildingblocks.challenges.domain.player.values.Action;
import com.buildingblocks.challenges.domain.player.values.Number;
import com.buildingblocks.shared.domain.generic.Entity;

public class Turn extends Entity<TurnId> {

    private Action action;
    private Number number;
    private IsActive isActive;

    public Turn(TurnId identity, Action action, Number number) {
        super(identity);
        this.action = action;
        this.number = number;
        this.isActive = IsActive.of(false);
    }

    public Turn(Action action, Number number) {
        super(new TurnId());
        this.action = action;
        this.number = number;
        this.isActive = IsActive.of(false);
    }

    public Action getAction() {
        return action;
    }

    public Number getNumber() {
        return number;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public void recordAction(Action action) {
        this.action = action;
        this.number = Number.of(this.number.getValue() + 1);
    }

    public int getActionCount() {
        return this.number.getValue();
    }

    public boolean isActive() {
        return isActive.getValue();
    }

    public void startTurn() {
        if (isActive.getValue()) {
            throw new IllegalStateException("Turn is already active");
        }
        this.isActive = IsActive.of(true);
    }

    public void endTurn() {
        if (!isActive.getValue()) {
            throw new IllegalStateException("Turn is already inactive");
        }
        this.isActive = IsActive.of(false);
    }
}