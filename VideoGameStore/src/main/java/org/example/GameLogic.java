package org.example;

public class GameLogic {

    public static void transferGame(Store store, Customer from, Customer to, String gameName) {
        Game gameToTransfer = store.removeGameByName(gameName);
        if (gameToTransfer != null) {
            from.removeGame(gameToTransfer);
            store.addGame(gameToTransfer);
            System.out.println("Game transferred succesfully!");
        } else {
            System.out.println("Game not found in source inventory.");
        }
    }

    public static void sellGame(Store store, Customer buyer, String gameName) {
        Game gameToSell = store.getGameByName(gameName);
        if (gameToSell != null) {
            buyer.purchaseGame(gameToSell);
            store.removeGame(gameToSell);
        }
    }
}

