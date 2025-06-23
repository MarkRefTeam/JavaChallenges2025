package org.example;

import java.util.List;

public abstract class Pet {

    private String name;
    private int age;
    private String skill;
    private double weight;
    protected boolean isHungry;
    protected String mood;
    protected List<String> tricks;
    protected boolean isSleep;


    public Pet(String name, int age, String skill, double weight, String mood, boolean isHungry,
               List<String> tricks, boolean isSleep) {
        this.name = name;
        this.age = age;
        this.skill = skill;
        this.weight = weight;
        this.mood = mood;
        this.isHungry = isHungry;
        this.tricks = tricks;
        this.isSleep = isSleep;
    }

    public boolean isSleep() {
        return isSleep;
    }

    public void setSleep(boolean sleep) {
        isSleep = sleep;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public List<String> getTricks() {
        return tricks;
    }

    public void setTricks(List<String> tricks) {
        this.tricks = tricks;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getDescription() {
        return name + " is a " + age + " year old pet with skill: "+ skill +
                ". Mood: " + mood + ", Hungry: " + isHungry + ", Tricks: " +
                tricks;
    }

    public abstract void makeSound();
}

