package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameLogicTest {

    @Test
    void testSuccessfulGameTransfer() {
        Store store = new Store();
        Customer from = new Customer("Mark", 100);
        Customer to = new Customer("Ancsa", 100);

        Game doom = new Game("Doom", "FPS", 49.99, true);

        store.addGame(doom);
        from.addGame(doom);

        store.addCustomer(from);
        store.addCustomer(to);

        GameLogic.transferGame(store, from, to, "Doom");

        assertFalse(from.getOwnedGames().contains(doom));
        assertTrue(to.getOwnedGames().contains(doom));
    }

    @Test
    void testTransferGame_GameNotFound() {
        Store store = new Store();
        Customer from = new Customer("Mark", 100);
        Customer to = new Customer("Ancsa", 100);

        store.addCustomer(from);
        store.addCustomer(to);

        GameLogic.transferGame(store, from, to, "Doom");

        assertFalse(from.getOwnedGames().stream().anyMatch(g -> g.getTitle().equalsIgnoreCase("Doom")));
        assertFalse(to.getOwnedGames().stream().anyMatch(g -> g.getTitle().equalsIgnoreCase("Doom")));
    }

    //Explanation for the study: (Just to myself)
    //- to.getOwnedGames() // Gets the list of games owned by the user.
    //- .stream() // Converts the list into a stream so we can process it.
    //- .anyMatch(g -> Check if any element in the list matches a condition.
    //- g -> g.getTitle().equalsIgnoreCase("Doom") // Condition: title is "Doom" (a case doesn't matter)

}
