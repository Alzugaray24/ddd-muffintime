package com.buildingblocks.challenges.domain.card.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class RewardAwarded extends DomainEvent {
    private final String rewardId;
    private final String awardDetails;

    public RewardAwarded(String rewardId, String awardDetails) {
        super(EventsEnum.REWARD_AWARDED.name());
        this.rewardId = rewardId;
        this.awardDetails = awardDetails;
    }

    public String getRewardId() {
        return rewardId;
    }

    public String getAwardDetails() {
        return awardDetails;
    }
}