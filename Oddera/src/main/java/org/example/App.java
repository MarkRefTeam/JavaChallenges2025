package org.example;
import org.example.engine.GameLauncher;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.Dungeon.enterDungeon;

public class App {

    static Scanner sc = new Scanner(System.in);
    static List<Integer> party = new ArrayList<>();

    public static void main(String[] args) {

        GameLauncher launcher = new GameLauncher();

        //Methods:
        showMainMenu();
        createYourCharter(1);
        addToParty(2);
        launcher.start();



        Dungeon.enterDungeon(3);
        CharacterStats.warriorStats();
        CharacterStats.archerStats();
        CharacterStats.mageStats();

        Character player1 = new Character("Kodiak", "Warrior", 150, 30);
        Character player2 = new Character("Kodiak", "Mage", 50, 90);
        Character player3 = new Character("Kodiak", "Archer", 90, 60);

        player1.displayStats();
        player2.displayStats();
        player3.displayStats();

        /**
         * 🏰 Welcome to Oddera!
         * The first city on the road to Nullgrad!
         * <p>
         * 🧙‍♂️ Here you can:
         * - Create your hero
         * - Level up your stats
         * - Go shopping
         * - Look for a party to enter the Dungeon
         * <p>
         * 🍀 Good luck, adventurer!
         */

        /// Create and choose a class!
    }

    public static void showMainMenu() {
        boolean running = true;

        while (running) {
            System.out.println("===Welcome to Oddera!===");
            System.out.println("1. create your charters");
            System.out.println();
            System.out.println("2. Vien Party");
            System.out.println();
            System.out.println("3. Enter Dungeon");
            System.out.println();
            System.out.println("4. Enter Arena");         //Soon!
            System.out.println();
            System.out.println("5. Portal other cities"); //Soon!
            System.out.println();
            System.out.println("6. Lore and statistic");  //Soon!
            System.out.println();
            System.out.println("7. May you have a question?(Chatbot)"); //Soon!
            System.out.println();
            System.out.println("8. Exit");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    createYourCharter(1);
                    break;
                case 2:
                    addToParty(2);
                    break;
                case 3:
                    enterDungeon(3);
                    break;
                case 8:
                    System.out.println("Exiting Game, Goodbye");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.Please try again");
            }
        }
    }

    public static String createYourCharter(int input) {
        System.out.println("You can create your charter");
        System.out.println();
        System.out.println("Please choose a number between 1 and 3");

        switch (input) {
            case 1:
                return "Warrior";
            case 2:
                return "Mage";
            case 3:
                return "Archer";
            default:
                return "Invalid Choice";

        }
    }

    /// Create a Party!

    public static int addToParty(int input) {
        System.out.println("You can create your party");

        if (input >= 1 && input <= 3) {
            party.add(input);
            System.out.println("Charter Added to your party");
        } else {
            System.out.println("Invalid Charter selection");
        }
        return party.size() - 1;
    }

}
