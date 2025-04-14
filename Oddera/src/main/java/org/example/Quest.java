package org.example;

public class Quest {

    private String name;
    private int targetCount;
    private int currentCount;
    private int rewardXP;

    public Quest(String name,int targetCount,int rewardXP) {

        this.name = name;
        this.targetCount = targetCount;
        this.rewardXP = rewardXP;
        this.currentCount = 0;
    }

    public void incrementProgress() {
        if(!isCompleted()) {
            currentCount++;
        }
    }

    public boolean isCompleted() {
        return currentCount >= targetCount;
    }

    public int getRewardXP() {
        return rewardXP;
    }

    public String getStatus() {
        return name + ": " + currentCount + "/ " + targetCount + (isCompleted()? "(Completed)": "");
    }
}
