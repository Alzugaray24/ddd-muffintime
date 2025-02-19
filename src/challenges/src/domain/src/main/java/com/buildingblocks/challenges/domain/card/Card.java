// Card.java
package com.buildingblocks.challenges.domain.card;

import com.buildingblocks.challenges.domain.card.entities.Effect;
import com.buildingblocks.challenges.domain.card.entities.Reward;
import com.buildingblocks.challenges.domain.card.events.*;
import com.buildingblocks.challenges.domain.card.values.CardId;
import com.buildingblocks.challenges.domain.card.values.Description;
import com.buildingblocks.challenges.domain.card.values.Title;
import com.buildingblocks.challenges.domain.card.values.Type;
import com.buildingblocks.challenges.domain.card.values.IsActive;
import com.buildingblocks.shared.domain.generic.AggregateRoot;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.util.List;

public class Card extends AggregateRoot<CardId> {

    private Title title;
    private Description description;
    private Type type;
    private IsActive active;
    private Effect effect;
    private Reward reward;

    // region Constructors

    public Card(){
        super(new CardId());
        this.active = IsActive.of(false);
        subscribe(new CardHandler(this));
    }

    private Card(CardId identity){
        super(identity);
        this.active = IsActive.of(false);
        subscribe(new CardHandler(this));
    }

    // endregion

    // region Getters and Setters


    public IsActive getActive() {
        return active;
    }

    public void setActive(IsActive active) {
        this.active = active;
    }

    // endregion

    // region Domain Events

    public void activateCard(String cardId){
        apply(new CardActivated(cardId));
    }

    public void deactivateCard(String cardId){
        apply(new CardDeactivated(cardId));
    }

    // endregion

    // region Public methods

    public static Card from(final String identity, final List<DomainEvent> events) {
        Card card = new Card(CardId.of(identity));
        events.forEach(card::apply);
        return card;
    }

    // endregion
}