package com.buildingblocks.challenges.domain.player;

import com.buildingblocks.challenges.domain.card.Card;
import com.buildingblocks.challenges.domain.player.entities.ActionHistory;
import com.buildingblocks.challenges.domain.player.entities.Turn;
import com.buildingblocks.challenges.domain.player.events.HistoryUpdated;
import com.buildingblocks.challenges.domain.player.events.PlayerTurnFinished;
import com.buildingblocks.challenges.domain.player.events.PlayerTurnStarted;
import com.buildingblocks.challenges.domain.player.values.*;
import com.buildingblocks.shared.domain.generic.AggregateRoot;

import java.util.List;

public class Player extends AggregateRoot<PlayerId> {

    private FirstName firstName;
    private LastName lastName;
    private State state;
    private Turn turn;
    private ActionHistory actionHistory;
    private List<Card> cards;

    // region Constructors

    public Player(){
        super(new PlayerId());
    }

    private Player(PlayerId identity){
        super(identity);
    }

    // endregion

    // region Getters and Setters

    public FirstName getFirstName() {
        return firstName;
    }

    public void setFirstName(FirstName firstName) {
        this.firstName = firstName;
    }

    public LastName getLastName() {
        return lastName;
    }

    public void setLastName(LastName lastName) {
        this.lastName = lastName;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Turn getTurn() {
        return turn;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    public ActionHistory getActionHistory() {
        return actionHistory;
    }

    public void setActionHistory(ActionHistory actionHistory) {
        this.actionHistory = actionHistory;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }


    // endregion

    // region Domain Events

    public void updateHistory (String historyId, String action){
        apply(new HistoryUpdated(historyId, action));
    }

    public void startTurn(String playerId){
        apply(new PlayerTurnStarted(playerId));
    }

    public void endTurn(String playerId){
        apply(new PlayerTurnFinished(playerId));
    }



    // endregion

    // region Public methods

    public void registerTurn(Turn turn) {
        try {
            validateTurn(turn);
            this.turn = turn;
            startTurn(this.getIdentity().getValue());
        } catch (IllegalArgumentException e) {
            endTurn(this.getIdentity().getValue());
        }
    }

    public void throwCard(Card card) {
        if (cards.contains(card)) {
            cards.remove(card);
            updateHistory(this.getIdentity().getValue(), "Card thrown: " + card.getTitle().toString());
        } else {
            throw new IllegalArgumentException("Card not found in player's hand");
        }
    }

    public void takeCard(Card card) {
        cards.add(card);
        updateHistory(this.getIdentity().getValue(), "Card taken: " + card.getTitle().toString());
    }

    // endregion

    // region Private methods

    private void validateTurn(Turn turn) {
        if (turn == null) {
            throw new IllegalArgumentException("Turn cannot be null");
        }
    }

    // endregion
}
