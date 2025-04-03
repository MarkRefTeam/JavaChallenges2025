package org.example;

public class Character {

    public String name;
    public String heroClass;
    public int hp;
    public int attack;


    public Character(String name, String heroClass, int hp, int attack) {
        this.name = name;
        this.heroClass = heroClass;
        this.hp = hp;
        this.attack = attack;
    }

    public void displayStats() {
        System.out.println("Name: " + name);
        System.out.println("Class: " + heroClass);
        System.out.println("HP: " + hp);
        System.out.println("Attack" + attack);
    }
}

