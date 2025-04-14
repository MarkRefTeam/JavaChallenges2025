package org.example.engine;

import org.example.PlayerCharacter;
import org.example.Quest;

public class GameLauncher {

    public void start() {

        PlayerCharacter player = new PlayerCharacter("Oddera");
        Quest quest1 = new Quest("Defeat 5 slimes", 5, 100);
        player.addQuest(quest1);

        for (int i = 0; i < 5; i++) {
            player.completeAction("enemyDefeated");
        }

        player.showStats();
    }


}
