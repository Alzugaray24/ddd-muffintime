// Player.java
package com.buildingblocks.challenges.domain.player;

import com.buildingblocks.challenges.domain.card.Card;
import com.buildingblocks.challenges.domain.player.entities.ActionHistory;
import com.buildingblocks.challenges.domain.player.entities.Turn;
import com.buildingblocks.challenges.domain.player.events.*;
import com.buildingblocks.challenges.domain.player.values.*;
import com.buildingblocks.shared.domain.generic.AggregateRoot;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class Player extends AggregateRoot<PlayerId> {

    private NickName nickName;
    private State state;
    private Turn turn;
    private ActionHistory actionHistory;
    private List<Card> cards = new ArrayList<>();

    // region Constructors

    public Player(){
        super(new PlayerId());
        subscribe(new PlayerHandler(this));
    }

    private Player(PlayerId identity){
        super(identity);
        subscribe(new PlayerHandler(this));
    }

    // endregion

    // region Getters and Setters

    public NickName getNickName() {
        return nickName;
    }

    public void setNickName(NickName nickName) {
        this.nickName = nickName;
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
        this.cards = new ArrayList<>(cards);
    }
    // endregion

    // region Domain Events

    public void createPlayer(String nickName){
        apply(new PlayerCreated(nickName));
    }

    public void recordAction(Action action){
        apply(new PlayerActionRecorded(action));
    }

    public void drawnCard(Card cardId){
        apply(new CardDrawn(cardId));
    }

    public void playCard(Card cardId){
        apply(new CardPlayed(cardId));
    }

    public void changeState(State state){
        apply(new PlayerStateChanged(state));
    }

    // endregion

    // region Public methods

    // endregion

    // region Private methods

    private Boolean canPlayCard() {
        return turn.isActive();
    }

    private Boolean canDrawCard() {
        return turn.isActive();
    }

    // endregion

    public static Player from(final String identity, final List<DomainEvent> events) {
        Player player = new Player(PlayerId.of(identity));
        events.forEach(player::apply);
        return player;
    }
}