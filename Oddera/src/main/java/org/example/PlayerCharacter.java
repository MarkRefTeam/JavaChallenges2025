package org.example;

import java.util.ArrayList;
import java.util.List;

public class PlayerCharacter {

    private String name;
    private ExperienceSystem xpSystem;
    private List<Quest> activeQuests;

    public PlayerCharacter(String name) {
        this.name = name;
        this.xpSystem = new ExperienceSystem();
        this.activeQuests = new ArrayList<>();
    }

    public void addQuest(Quest quest) {

        activeQuests.add(quest);
    }

    public void completeAction(String actionType) {
        for (Quest q : activeQuests) {
            if (!q.isCompleted()) {
                q.incrementProgress();
                if (q.isCompleted()) {
                    System.out.println("Quest completed: " + q.getStatus());
                    xpSystem.gainXP(q.getRewardXP());
                }
            }
        }
    }

    public void showStats() {
        System.out.println("Level: " + xpSystem.getLevel());
        System.out.println("Xp: " + xpSystem.getCurrentXP() + "/" + xpSystem.getXpToNextLevel());
        for (Quest q : activeQuests) {
            System.out.println(q.getStatus());
        }
    }
}
