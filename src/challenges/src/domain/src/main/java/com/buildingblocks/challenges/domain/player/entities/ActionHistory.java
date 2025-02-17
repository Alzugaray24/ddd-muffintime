package com.buildingblocks.challenges.domain.player.entities;

import com.buildingblocks.challenges.domain.player.values.Action;
import com.buildingblocks.challenges.domain.player.values.ActionHistoryId;
import com.buildingblocks.challenges.domain.player.values.Number;
import com.buildingblocks.shared.domain.generic.Entity;

public class ActionHistory extends Entity<ActionHistoryId> {

    private Action action;
    private Number number;

    public ActionHistory(ActionHistoryId identity, Action action, Number number) {
        super(identity);
        this.action = action;
        this.number = number;
    }

    public ActionHistory(Action action, Number number) {
        super(new ActionHistoryId());
        this.action = action;
        this.number = number;
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
}