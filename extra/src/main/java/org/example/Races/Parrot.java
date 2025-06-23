package org.example.Races;

import lombok.Data;
import org.example.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Parrot extends Pet {

    private List<String> vocabulary = new ArrayList<>();

    public List<String> getVocabulary() {
        return vocabulary;
    }

    public Parrot(String name, int age, String skill, double weight, String mood, boolean isHungry,
                  List<String> tricks, boolean isSleep, List<String> vocabulary) {
        super(name, age, skill, weight, mood, isHungry, tricks, isSleep);
    }

    @Override
    public void makeSound() {
        System.out.println("Squawk!");
    }

    public String repeat(String words) {
        return words + words;
    }

    public void fly() {
        System.out.println(getName() + " is flying!");
    }

    public void eat() {
        isHungry = false;
        mood = "happy";
        System.out.println(getName() + " is wanna talking now before dinner ...!");
    }

    public void learnNewWord(String word) {
        if (vocabulary.contains(word)) {
            System.out.println(getName() + " already knows the word \"" + word + "\"!");
            mood = "Proud";
        } else {
            vocabulary.add(word);
            mood = "Curious";
            System.out.println(getName() + " learned a new word: \"" + word + "\"!");
        }
    }

    public void showVocabularySize() {
        System.out.println(getName() + " knows " + vocabulary.size() + " words.");
    }

    public void sayRandomWord() {
        if (vocabulary.isEmpty()) {
            System.out.println(getName() + " is silent... no words yet.");
        } else {
            int index = new Random().nextInt(vocabulary.size());
            System.out.println(getName() + " says: \"" + vocabulary.get(index) + "\"");
        }
    }
}