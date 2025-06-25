package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameLogicTest {

    @Test
    void testGameIsInStockTrue() {
        Game game = new Game("Minecraft", "Sandbox", 29.99, true);
        assertTrue(game.isInStock());
    }

    @Test
    void testTransferFailsIfCustomerNotInStore() {
        Store store = new Store();
        Customer notInStore = new Customer("Ghost", 100);
        Customer receiver = new Customer("Player", 100);
        Game game = new Game("Zelda", "Adventure", 59.99, true);

        store.addGame(game);
        store.addCustomer(receiver);

        boolean result = GameLogic.transferGame(store, notInStore, receiver, "Zelda");
        assertFalse(result);
    }
}
