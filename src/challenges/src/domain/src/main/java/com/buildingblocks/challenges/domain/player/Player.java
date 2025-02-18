package com.buildingblocks.challenges.domain.player;

import com.buildingblocks.challenges.domain.card.Card;
import com.buildingblocks.challenges.domain.player.entities.ActionHistory;
import com.buildingblocks.challenges.domain.player.entities.Turn;
import com.buildingblocks.challenges.domain.player.events.*;
import com.buildingblocks.challenges.domain.player.values.*;
import com.buildingblocks.shared.domain.generic.AggregateRoot;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class Player extends AggregateRoot<PlayerId> {

    private NickName nickName;
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
        this.cards = cards;
    }


    // endregion

    // region Domain Events

    public void createPlayer(String playerId, String nickName){
        apply(new PlayerCreated(playerId, nickName));
    }

    public void recordAction(String playerId, Action action){
       apply(new PlayerActionRecorded(playerId, action));
    }

    public  void cardDrawn(String playerId, Card cardId){
        apply(new CardDrawn(playerId, cardId));
    }

    public  void playCard (String playerId, Card cardId){
        apply(new CardPlayed(playerId, cardId));
    }

    public void changeState(String playerId, State state){
        apply(new PlayerStateChanged(playerId, state));
    }

    // endregion

    // region Public methods

    public void drawCard(Card card) {
        if (Objects.equals(state.getStatus().toString(), "ACTIVE")) {
            if (Boolean.TRUE.equals(canDrawCard())) {
                cards.add(card);
            } else {
                throw new IllegalStateException("Cannot draw card");
            }
        } else {
            throw new IllegalStateException("Player is not active");
        }
    }

    public void playCard(Card card) {
        if (Objects.equals(state.getStatus().toString(), "ACTIVE")) {
            if (Boolean.TRUE.equals(canPlayCard())) {
                cards.remove(card);
            } else {
                throw new IllegalStateException("Cannot play card");
            }
        } else {
            throw new IllegalStateException("Player is not active");
        }
    }

    // endregion

    // region Private methods

    private Boolean canPlayCard() {
        return turn.isActive();
    }

    private Boolean canDrawCard() {
        return turn.isActive();
    }

    // endregion

    public static Player from(final String identity, final NickName nickName, final State state, final Turn turn, final ActionHistory actionHistory, final List<Card> cards, final List<DomainEvent> domainEvents) {
        Player player = new Player(PlayerId.of(identity));
        player.setNickName(nickName);
        player.setState(state);
        player.setTurn(turn);
        player.setActionHistory(actionHistory);
        player.setCards(cards);

        domainEvents.forEach(player::apply);
        return player;
    }
}
