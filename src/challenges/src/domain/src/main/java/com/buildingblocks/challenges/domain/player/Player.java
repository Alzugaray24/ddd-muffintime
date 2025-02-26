// Player.java
package com.buildingblocks.challenges.domain.player;

import com.buildingblocks.challenges.domain.card.Card;
import com.buildingblocks.challenges.domain.player.entities.ActionHistory;
import com.buildingblocks.challenges.domain.player.entities.Turn;
import com.buildingblocks.challenges.domain.player.events.*;
import com.buildingblocks.challenges.domain.player.values.*;
import com.buildingblocks.shared.domain.generic.AggregateRoot;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Player extends AggregateRoot<PlayerId> {

    private NickName nickName;
    private State state;
    private List<Card> cards = new ArrayList<>();
    private ActionHistory actionHistory;
    private Turn turn;

    // region Constructors

    public Player() {
        super(new PlayerId());
        this.state = State.of(StateEnum.INACTIVE);
        this.actionHistory = new ActionHistory(new ArrayList<>(), LocalDateTime.now());
        this.turn = new Turn(LocalTime.now(), null);
        subscribe(new PlayerHandler(this));
    }

    public Player(String nickName) {
        super(new PlayerId());
        this.nickName = NickName.of(nickName);
        this.state = State.of(StateEnum.INACTIVE);
        this.actionHistory = new ActionHistory(new ArrayList<>(), LocalDateTime.now());
        this.turn = new Turn(LocalTime.now(), null);
        subscribe(new PlayerHandler(this));
    }

    private Player(PlayerId identity) {
        super(identity);
        this.state = State.of(StateEnum.INACTIVE);
        this.actionHistory = new ActionHistory(new ArrayList<>(), LocalDateTime.now());
        this.turn = new Turn(LocalTime.now(), null);
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

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public ActionHistory getActionHistory() {
        return actionHistory;
    }

    public void setActionHistory(ActionHistory actionHistory) {
        this.actionHistory = actionHistory;
    }

    public Turn getTurn() {
        return turn;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    public String getNickNameValue() {
        return this.nickName.getValue();
    }

    // endregion

    // region Domain Events

    public void createPlayer(String nickName) {
        apply(new PlayerCreated(nickName));
    }

    public void drawnCard(String cardId) {
        apply(new CardDrawn(cardId));
    }

    public void playCard(String  cardId) {
        apply(new CardPlayed(cardId));
    }

    public void changeState(String state) {
        apply(new PlayerStateChanged(state));
    }

    // endregion

    // region Public methods

    public void createInitialCards() {
        for (int i = 0; i < 5; i++) {
            Card card = new Card();
            this.cards.add(card);
        }
    }

    // endregion

    // region Private methods

    // endregion

    public static Player from(final String identity, final List<DomainEvent> events) {
        Player player = new Player(PlayerId.of(identity));
        events.forEach(player::apply);
        player.markEventsAsCommitted();
        return player;
    }

}