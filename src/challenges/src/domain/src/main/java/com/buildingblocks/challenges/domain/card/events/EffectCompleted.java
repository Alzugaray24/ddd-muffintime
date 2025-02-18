package com.buildingblocks.challenges.domain.card.events;

import com.buildingblocks.shared.domain.generic.DomainEvent;

public class EffectCompleted extends DomainEvent {
    private final String challengeId;

    public EffectCompleted(String challengeId) {
        super(EventsEnum.EFFECT_COMPLETED.name());
        this.challengeId = challengeId;
    }

    public String getChallengeId() {
        return challengeId;
    }

}