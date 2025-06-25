package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StoreTest {

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
}
