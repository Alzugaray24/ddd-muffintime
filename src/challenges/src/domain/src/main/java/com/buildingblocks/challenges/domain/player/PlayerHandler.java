// PlayerHandler.java
package com.buildingblocks.challenges.domain.player;

import com.buildingblocks.challenges.domain.card.Card;
import com.buildingblocks.challenges.domain.player.entities.ActionHistory;
import com.buildingblocks.challenges.domain.player.entities.Turn;
import com.buildingblocks.challenges.domain.player.events.CardDrawn;
import com.buildingblocks.challenges.domain.player.events.CardPlayed;
import com.buildingblocks.challenges.domain.player.events.PlayerCreated;
import com.buildingblocks.challenges.domain.player.events.PlayerStateChanged;
import com.buildingblocks.challenges.domain.player.values.Action;
import com.buildingblocks.challenges.domain.player.values.NickName;
import com.buildingblocks.challenges.domain.player.values.State;
import com.buildingblocks.challenges.domain.player.values.StateEnum;
import com.buildingblocks.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PlayerHandler extends DomainActionsContainer {

    public PlayerHandler(Player player) {
        add(createPlayer(player));
        add(changePlayerState(player));
        add(playCard(player));
        add(drawCard(player));
    }

    private Consumer<? super DomainEvent> createPlayer(Player player) {
        return (DomainEvent event) -> {
            if (event instanceof PlayerCreated playerCreated) {
                player.setNickName(NickName.of(playerCreated.getNickName()));
                player.setState(State.of(StateEnum.ACTIVE));
                player.setActionHistory(new ActionHistory(new ArrayList<>(), LocalDateTime.now()));
                player.setTurn(new Turn(LocalTime.now(), null));
            }
        };
    }

    private Consumer<? super DomainEvent> changePlayerState(Player player) {
        return (DomainEvent event) -> {
            if (event instanceof PlayerStateChanged playerStateChanged) {
                player.setState(State.of(StateEnum.valueOf(playerStateChanged.getNewState())));
            }
        };
    }

    private Consumer<? super DomainEvent> playCard(Player player) {
        return (DomainEvent event) -> {
            if (event instanceof CardPlayed cardPlayed) {
                    player.getCards().remove(cardPlayed.getCardId());
                    player.getActionHistory().addAction(Action.of(cardPlayed.getCardId()));
                    player.getTurn().finalizeTurn();
            }
        };
    }

    private Consumer<? super DomainEvent> drawCard(Player player) {
        return (DomainEvent event) -> {
            if (event instanceof CardDrawn cardDrawn) {
                    Card card = Card.from(cardDrawn.getCardId(), List.of());
                    player.getCards().add(card);
                    player.getTurn().startTurn();
                }

        };
    }
}