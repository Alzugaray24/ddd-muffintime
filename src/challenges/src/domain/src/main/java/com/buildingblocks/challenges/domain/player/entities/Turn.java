// Turn.java
package com.buildingblocks.challenges.domain.player.entities;

import com.buildingblocks.challenges.domain.player.values.IsActive;
import com.buildingblocks.challenges.domain.player.values.TurnId;
import com.buildingblocks.challenges.domain.player.values.Action;
import com.buildingblocks.challenges.domain.player.values.Number;
import com.buildingblocks.shared.domain.generic.Entity;

import java.time.LocalTime;

public class Turn extends Entity<TurnId> {

    private IsActive isActive;
    private LocalTime startTime;
    private LocalTime endTime;

    public Turn(TurnId identity, LocalTime startTime, LocalTime endTime) {
        super(identity);
        this.startTime = startTime;
        this.endTime = endTime;
        this.isActive = IsActive.of(true);
    }

    public Turn(LocalTime startTime, LocalTime endTime) {
        super(new TurnId());
        this.startTime = startTime;
        this.endTime = endTime;
        this.isActive = IsActive.of(true);
    }

    public IsActive getIsActive() {
        return isActive;
    }

    public void setIsActive(IsActive isActive) {
        this.isActive = isActive;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void finalizeTurn() {
        this.endTime = LocalTime.now();
        this.isActive = IsActive.of(false);
    }

    public void startTurn() {
        this.startTime = LocalTime.now();
        this.isActive = IsActive.of(true);
    }

    public long getTurnDuration() {
        if (startTime == null || endTime == null) {
            return 0;
        }
        return java.time.Duration.between(startTime, endTime).getSeconds();
    }


}