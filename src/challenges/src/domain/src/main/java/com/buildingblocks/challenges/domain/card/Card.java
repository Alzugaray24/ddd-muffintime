// Card.java
package com.buildingblocks.challenges.domain.card;

import com.buildingblocks.challenges.domain.card.entities.ActivationCondition;
import com.buildingblocks.challenges.domain.card.entities.Effect;
import com.buildingblocks.challenges.domain.card.entities.Reward;
import com.buildingblocks.challenges.domain.card.events.*;
import com.buildingblocks.challenges.domain.card.values.CardId;
import com.buildingblocks.challenges.domain.card.values.Description;
import com.buildingblocks.challenges.domain.card.values.Title;
import com.buildingblocks.challenges.domain.card.values.Type;
import com.buildingblocks.shared.domain.generic.AggregateRoot;

public class Card extends AggregateRoot<CardId> {

    private Title title;
    private Description description;
    private Type type;
    private ActivationCondition activationCondition;
    private Effect effect;
    private Reward reward;

    // region Constructors

    public Card(){
        super(new CardId());
    }

    private Card(CardId identity){
        super(identity);
    }

    // endregion

    // region Getters and Setters

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ActivationCondition getActivationCondition() {
        return activationCondition;
    }

    public void setActivationCondition(ActivationCondition activationCondition) {
        this.activationCondition = activationCondition;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    // endregion

    // region Domain Events

    public void activateCondition (String conditionId, String conditionDetails){
        apply(new ConditionActivated(conditionId, conditionDetails));
    }

    public void activateCard (String cardId){
        apply(new CardActivated(cardId));
    }

    public void deactivateCard (String cardId){
        apply(new CardDeactivated(cardId));
    }

    public void completeChallenge (String challengeId){
        apply(new ChallengeCompleted(challengeId));
    }

    public void activeEffect(String effectId){
        apply(new EffectActivated(effectId));
    }

    public void deactivateEffect(String effectId){
        apply(new EffectDeactivated(effectId));
    }

    public void applyReward(String rewardId, String rewardDetails){
        apply(new RewardAwarded(rewardId, rewardDetails));
    }

    public void startChallenge (String challengeId){
        apply(new ChallengeStarted(challengeId));
    }

    // endregion

    // region Public methods

    public void playCard() {
        if (canPlayCard()) {
            activateCard(this.getIdentity().getValue());
            activeEffect(this.effect.getIdentity().getValue());
        } else {
            throw new IllegalStateException("Cannot play card under current conditions");
        }
    }

    public void discardCard() {
        if (canDiscardCard()) {
            deactivateCard(this.getIdentity().getValue());
        } else {
            throw new IllegalStateException("Cannot discard card under current conditions");
        }
    }

    // endregion

    // region Private methods

    private boolean canPlayCard() {
        return true;
    }

    private boolean canDiscardCard() {
        return true;
    }

    // endregion
}