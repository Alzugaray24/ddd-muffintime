// PlayerTest.java
package com.buildingblocks.challenges.domain;

import com.buildingblocks.challenges.domain.card.Card;
import com.buildingblocks.challenges.domain.player.Player;
import com.buildingblocks.challenges.domain.player.values.State;
import com.buildingblocks.challenges.domain.player.values.StateEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void drawCardSuccess() {
        Card card = new Card(/* initialize card properties */);
        player.changeState(State.of(StateEnum.ACTIVE));

        player.drawnCard(card);

        assertEquals(1, player.getCards().size());
    }
}