package org.example;

public class Games {

    public static Game[] getPreloadedGames() {
        return new Game[]{
                new Game("Elder Scrolls", "RPG", 59.99, true),
                new Game("Doom Eternal", "FPS", 49.99, true),
                new Game("Cyberpunk 2077", "RPG", 39.99, false),
                new Game("The Witcher 3", "RPG", 29.99, true),
                new Game("Minecraft", "Sandbox", 19.99, true),
                new Game("Valorant", "FPS", 0.00, true),
                new Game("Overwatch", "Shooter", 39.99, false),
                new Game("Red Dead Redemption 2", "Action", 69.99, true),
                new Game("Hades", "Roguelike", 24.99, true),
                new Game("Stardew Valley", "Simulation", 14.99, true),
                new Game("FIFA 23", "Sports", 59.99, false),
                new Game("Call of Duty", "Shooter", 69.99, true)
        };
    }
}
