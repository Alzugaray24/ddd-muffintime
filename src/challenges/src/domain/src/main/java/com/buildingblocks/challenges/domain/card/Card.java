// Card.java
package com.buildingblocks.challenges.domain.card;

import com.buildingblocks.challenges.domain.card.entities.Effect;
import com.buildingblocks.challenges.domain.card.entities.Reward;
import com.buildingblocks.challenges.domain.card.events.*;
import com.buildingblocks.challenges.domain.card.values.CardId;
import com.buildingblocks.challenges.domain.card.values.Description;
import com.buildingblocks.challenges.domain.card.values.Title;
import com.buildingblocks.challenges.domain.card.values.Type;
import com.buildingblocks.challenges.domain.player.values.IsActive;
import com.buildingblocks.shared.domain.generic.AggregateRoot;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.util.List;

public class Card extends AggregateRoot<CardId> {

    private Title title;
    private Description description;
    private Type type;
    private Effect effect;
    private Reward reward;
    private IsActive active;

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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

    public IsActive getActive() {
        return active;
    }

    public void setActive(IsActive active) {
        this.active = active;
    }

    public void activate() {
        this.active = IsActive.of(true);
    }

    public void deactivate() {
        this.active = IsActive.of(false);
    }

    // endregion

    // region Domain Events


    public void activateCard (String cardId){
        apply(new CardActivated(cardId));
    }

    public void deactivateCard (String cardId){
        apply(new CardDeactivated(cardId));
    }

    public IsActive getId() {
        return active;
    }


    // endregion

    // region Public methods


    // endregion

    // region Private methods


    // endregion

    public static Card from(final String identity, final Title title, final Description description, final Type type, final Effect effect, final Reward reward, final IsActive active, final List<DomainEvent> domainEvents) {
        Card card = new Card(CardId.of(identity));
        card.setTitle(title);
        card.setDescription(description);
        card.setType(type);
        card.setEffect(effect);
        card.setReward(reward);
        card.setActive(active);

        domainEvents.forEach(card::apply);
        return card;
    }
}