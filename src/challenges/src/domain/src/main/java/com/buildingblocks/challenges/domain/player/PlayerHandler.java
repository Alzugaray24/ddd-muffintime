// PlayerHandler.java
package com.buildingblocks.challenges.domain.player;

import com.buildingblocks.challenges.domain.player.events.CardDrawn;
import com.buildingblocks.challenges.domain.player.events.CardPlayed;
import com.buildingblocks.challenges.domain.player.events.PlayerCreated;
import com.buildingblocks.challenges.domain.player.events.PlayerStateChanged;
import com.buildingblocks.challenges.domain.player.values.NickName;
import com.buildingblocks.challenges.domain.player.values.StateEnum;
import com.buildingblocks.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.shared.domain.generic.DomainEvent;

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
            }
        };
    }

    private Consumer<? super DomainEvent> changePlayerState(Player player) {
        return (DomainEvent event) -> {
            if (event instanceof PlayerStateChanged playerStateChanged) {
                player.setState(playerStateChanged.getNewState());
            }
        };
    }

    private Consumer<? super DomainEvent> playCard(Player player) {
        return (DomainEvent event) -> {
            if (event instanceof CardPlayed cardPlayed) {
                if (player.getState().getValue() == StateEnum.INACTIVE) {
                    throw new IllegalStateException("Player is inactive");
                } else {
                    player.getCards().remove(cardPlayed.getCardId());
                }
            }
        };
    }

    private Consumer<? super DomainEvent> drawCard(Player player) {
        return (DomainEvent event) -> {
            if (event instanceof CardDrawn cardDrawn) {
                if (player.getState().getValue() == StateEnum.INACTIVE) {
                    throw new IllegalStateException("Player is inactive");
                } else {
                    player.getCards().add(cardDrawn.getCardId());
                }
            }
        };
    }
}