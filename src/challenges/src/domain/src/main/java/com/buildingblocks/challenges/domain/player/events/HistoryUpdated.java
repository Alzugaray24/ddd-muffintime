package com.buildingblocks.challenges.domain.player.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class HistoryUpdated extends DomainEvent {

    private final String historyId;
    private final String action;

    public HistoryUpdated( String historyId, String action) {
        super(EventsEnum.HISTORY_UPDATED.name());
        this.historyId = historyId;
        this.action = action;
    }

    public String getHistoryId() {
        return historyId;
    }

    public String getAction() {
        return action;
    }
}
