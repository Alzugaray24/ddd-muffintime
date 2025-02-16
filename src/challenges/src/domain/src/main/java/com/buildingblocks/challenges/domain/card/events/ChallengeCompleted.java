package com.buildingblocks.challenges.domain.card.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class ChallengeCompleted extends DomainEvent {
    private final String challengeId;

    public ChallengeCompleted(String challengeId) {
        super(EventsEnum.CHALLENGE_COMPLETED.name());
        this.challengeId = challengeId;
    }

    public String getChallengeId() {
        return challengeId;
    }

}