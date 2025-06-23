package org.example.Races;

import org.example.Pet;

import java.util.List;

public class Dog extends Pet {

    public Dog(String name, int age, String skill, double weight, String mood, boolean isHungry,
               List<String>tricks,boolean isSleep) {
        super(name,age,skill,weight,mood,isHungry,tricks,isSleep);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof");
    }

    public void run() {
        System.out.println(getName() + " is running fast");
    }

    public void eat() {
        isHungry = true;
        mood = "happy";
        System.out.println(getName() + "is eating ...!");
    }

    public void learnSkill(String newSkill) {
        tricks.add(newSkill);
        mood = "proud";
        System.out.println(getName() + " just learned a new skill: " + newSkill + "!");
    }
}
