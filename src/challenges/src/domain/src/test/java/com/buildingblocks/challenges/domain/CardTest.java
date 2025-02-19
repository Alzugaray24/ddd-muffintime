// CardTest.java
package com.buildingblocks.challenges.domain;

import com.buildingblocks.challenges.domain.card.Card;
import com.buildingblocks.challenges.domain.card.events.CardActivated;
import com.buildingblocks.challenges.domain.card.values.CardId;
import com.buildingblocks.shared.domain.generic.DomainEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {
    private Card card;

    @BeforeEach
    void setUp() {
        card = new Card();
    }

    @Test
    void activateCardSuccess() {
        card.activateCard("test-card-id");

        assertTrue(card.getActive().getValue());
    }

    @Test
    void deactivateCardSuccess() {
        card.activateCard("test-card-id");
        card.deactivateCard("test-card-id");

        assertFalse(card.getActive().getValue());
    }

    @Test
    void activateCardWhenAlreadyActiveThrowsException() {
        card.activateCard("test-card-id");

        assertThrows(IllegalArgumentException.class, () -> card.activateCard("test-card-id"));
    }

    @Test
    void deactivateCardWhenAlreadyInactiveThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> card.deactivateCard("test-card-id"));
    }

    @Test
    void fromMethod() {
        CardId identity = CardId.of("test-card-id");
        List<DomainEvent> events = List.of(new CardActivated("test-card-id"));

        Card card = Card.from(identity.getValue(), events);

        assertNotNull(card);
        assertTrue(card.getActive().getValue());
    }
}