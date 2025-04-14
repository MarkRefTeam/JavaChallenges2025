package org.example;

public class ExperienceSystem {

    private int currentXP;
    private int level;
    private int xpToNextLevel;

    public ExperienceSystem() {
        this.currentXP = 0;
        this.level = 1;
        this.xpToNextLevel = 100;
    }

    public void gainXP(int amount) {
        currentXP += amount;

        while(currentXP >= xpToNextLevel) {
            levelUp();
        }
    }

    private void levelUp() {
        currentXP -= xpToNextLevel;
        level++;
        xpToNextLevel += 50;
        System.out.println("Level up! New level: " + level);
    }

    public int getLevel() {
        return level;
    }

    public int getCurrentXP() {
        return currentXP;
    }

    public int getXpToNextLevel() {
        return xpToNextLevel;
    }
}
