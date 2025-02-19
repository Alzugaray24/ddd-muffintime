// PlayerTest.java
package com.buildingblocks.challenges.domain;

import com.buildingblocks.challenges.domain.card.Card;
import com.buildingblocks.challenges.domain.player.Player;
import com.buildingblocks.challenges.domain.player.entities.ActionHistory;
import com.buildingblocks.challenges.domain.player.entities.Turn;
import com.buildingblocks.challenges.domain.player.events.PlayerCreated;
import com.buildingblocks.challenges.domain.player.values.Action;
import com.buildingblocks.challenges.domain.player.values.State;
import com.buildingblocks.challenges.domain.player.values.StateEnum;
import com.buildingblocks.challenges.domain.player.values.NickName;
import com.buildingblocks.shared.domain.generic.DomainEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    void createPlayerSuccess() {
        String nickName = "PlayerOne";

        player.createPlayer(nickName);

        assertEquals(nickName, player.getNickName().getValue());
    }

    @Test
    void createPlayerFailure() {
        String invalidNickName = "";

        assertThrows(IllegalArgumentException.class, () -> player.createPlayer(invalidNickName));
    }

    @Test
    void changeStateSuccess() {
        State newState = State.of(StateEnum.ACTIVE);

        player.changeState(newState);

        assertEquals(newState, player.getState());
    }

    @Test
    void playCardSuccess() {
        Card card = new Card(/* initialize card properties */);
        player.setCards(Collections.singletonList(card));
        player.changeState(State.of(StateEnum.ACTIVE));

        player.playCard(card);

        assertEquals(0, player.getCards().size());
    }

    @Test
    void playCardWhenInactiveThrowsException() {
        Card card = new Card(/* initialize card properties */);
        player.setCards(Collections.singletonList(card));
        player.changeState(State.of(StateEnum.INACTIVE));

        assertThrows(IllegalStateException.class, () -> player.playCard(card));
    }

    @Test
    void drawCardSuccess() {
        Card card = new Card(/* initialize card properties */);
        player.changeState(State.of(StateEnum.ACTIVE));

        player.drawnCard(card);

        assertEquals(1, player.getCards().size());
    }

    @Test
    void drawCardWhenInactiveThrowsException() {
        Card card = new Card();
        player.changeState(State.of(StateEnum.INACTIVE));

        assertThrows(IllegalStateException.class, () -> player.drawnCard(card));
    }

    @Test
    void validateNickNameSuccess() {
        NickName nickName = NickName.of("ValidNickName");

        assertEquals("ValidNickName", nickName.getValue());
    }

    @Test
    void validateNickNameFailure() {
        assertThrows(IllegalArgumentException.class, () -> NickName.of(""));
    }

    @Test
    void fromMethod() {
        String identity = "player-1";
        List<DomainEvent> events = List.of(new PlayerCreated("PlayerOne"));

        Player player = Player.from(identity, events);

        assertNotNull(player);
        assertEquals(identity, player.getIdentity().getValue());
        assertEquals("PlayerOne", player.getNickName().getValue());
    }
}