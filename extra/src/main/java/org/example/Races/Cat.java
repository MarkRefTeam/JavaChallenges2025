package org.example.Races;

import org.example.Pet;

import java.util.List;

public class Cat extends Pet {

    public Cat(String name, int age, String skill, double weight, String mood, boolean isHungry,
               List<String> tricks,boolean isSleep) {
        super(name,age,skill,weight,mood,isHungry,tricks,isSleep);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }

    public void walk() {
        System.out.println(getName() + " is sneaking");
    }

    public void eat() {
        isHungry = true;
        mood = "confused";
        System.out.println(getName() + "How she haven't a food??? :O ...!");
    }

    public void learnSkill(String newSkill) {
        tricks.add(newSkill);
        mood = "no way";
        System.out.println(getName() + " just going to sleep: " + isSleep + "!");
    }
}
