package org.example;

import static org.example.App.party;

public class Dungeon {

    //Dungeon lvl 1.

    public static void enterDungeon(int input) {
        System.out.println("You enter the Dark Dungeon");

        if (party.isEmpty()) {
            System.out.println("You party is empty, you can't go in alone");
            return;
        }

        System.out.println("A wild Skeleton appears!");
        int enemyHp = 150;

        for (int i = 0; i < party.size(); i++) {
            int member = party.get(i);

            switch (member) {
                case 1:
                    System.out.println("Warrior strikes for 30 damage");
                    enemyHp -= 30;
                    break;
                case 2:
                    System.out.println("Mage cast a Fireball for 90 damage");
                    enemyHp -= 90;
                    break;
                case 3:
                    System.out.println("Archer shoots for 60 damage");
                    enemyHp -= 60;
                    break;
            }

            if(enemyHp <= 0) {
                System.out.println("The enemy survived with" + enemyHp + "HP!");
            }
        }
    }
}
