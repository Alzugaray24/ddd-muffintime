// PlayerHandler.java
package com.buildingblocks.challenges.domain.player;

import com.buildingblocks.challenges.domain.player.events.*;
import com.buildingblocks.challenges.domain.player.values.NickName;
import com.buildingblocks.challenges.domain.player.values.Number;
import com.buildingblocks.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.util.function.Consumer;

public class PlayerHandler extends DomainActionsContainer {

    private final Player player;

    public PlayerHandler(Player player) {
        this.player = player;
    }

    public Consumer<? extends DomainEvent> createPlayer() {
        return (PlayerCreated event) -> {
                player.setNickName(NickName.of(event.getNickName()));
                player.getActionHistory().setNumber(Number.of(0));
        };
    }

    public Consumer<? extends DomainEvent> playCard() {
        return (CardPlayed event) -> {
            if(player.getTurn().isActive()){
                player.playCard(event.getCardId());
            }else {
                throw new IllegalArgumentException("Player cannot play card because it is not his turn");
            }
        };
    }

    public Consumer<? extends DomainEvent> drawnCard() {
        return (CardDrawn event) -> {
            if (player.getIdentity().getValue().equals(event.getPlayerId())) {
                player.drawCard(event.getCardId());
            } else {
                throw new IllegalArgumentException("Player cannot draw card because it is not his turn");
            }
        };
    }


    public Consumer<? extends DomainEvent> changeState() {
        return (PlayerStateChanged event) -> {
            if (player.getState().equals(event.getNewState())) {
                throw new IllegalArgumentException("Player already in that state");
            } else {
                player.setState(event.getNewState());
            }
        };


    }

    public Consumer<? extends DomainEvent> recordPlayerAction() {
        return (PlayerActionRecorded event) -> player.getActionHistory().updateAction(event.getAction());
    }


}