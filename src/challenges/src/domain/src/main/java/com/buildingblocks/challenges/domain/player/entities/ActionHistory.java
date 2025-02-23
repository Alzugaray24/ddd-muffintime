package com.buildingblocks.challenges.domain.player.entities;

import com.buildingblocks.challenges.domain.player.values.Action;
import com.buildingblocks.challenges.domain.player.values.ActionHistoryId;
import com.buildingblocks.shared.domain.generic.Entity;

import java.time.LocalDateTime;
import java.util.List;

public class ActionHistory extends Entity<ActionHistoryId> {

    private List<Action> actions;
    private LocalDateTime createdAt;


    public ActionHistory(ActionHistoryId identity, List<Action> actions, LocalDateTime createdAt) {
        super(identity);
        this.actions = actions;
        this.createdAt = createdAt;
    }

    public ActionHistory(List<Action> actions, LocalDateTime createdAt) {
        super(new ActionHistoryId());
        this.actions = actions;
        this.createdAt = createdAt;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void addAction(Action action) {
        if (action == null) {
            throw new IllegalArgumentException("La acción no puede ser nula.");
        }
        this.actions.add(action);
    }

    public Action getLastAction() {
        if (actions.isEmpty()) {
            return null;
        }
        return actions.get(actions.size() - 1);
    }

    public boolean hasActions() {
        return !this.actions.isEmpty();
    }

    public int getTotalActions() {
        return this.actions.size();
    }

}