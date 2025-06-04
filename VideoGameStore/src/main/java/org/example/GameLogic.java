package org.example;

public class GameLogic {

    public static void transferGame(Store store,Customer from,Customer to,String gameName) {
        Game gameToTransfer = from.removeGameByName(gameName);
        if(gameToTransfer != null) {
            to.addGame(gameToTransfer);
            System.out.println("Game transferred succesfully!");
        } else {
            System.out.println("Game not found in source inventory.");
        }
    }

    public static void sellGame(Store store,Customer buyer,String gameName) {
        Game gameToSell = store.getGameByName(gameName);
        if(gameToSell != null) {
            buyer.addGame(gameToSell);
            store.removeGame(gameToSell);
            System.out.println("Game sold to " + buyer.getName());
        } else {
            System.out.println("Game not available in store.");
        }
    }
}
