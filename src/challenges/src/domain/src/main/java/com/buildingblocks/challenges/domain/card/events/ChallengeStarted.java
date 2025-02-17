package com.buildingblocks.challenges.domain.card.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class ChallengeStarted extends DomainEvent {
    private final String challengeId;

    public ChallengeStarted(String challengeId) {
        super(EventsEnum.CHALLENGE_STARTED.name());
        this.challengeId = challengeId;
    }

    public String getChallengeId() {
        return challengeId;
    }

}