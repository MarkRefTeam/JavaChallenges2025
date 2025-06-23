package org.example;

import org.example.Races.Cat;
import org.example.Races.Dog;
import org.example.Races.Parrot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello , here is your Pet selector: ");
        System.out.println("1.Dog");
        System.out.println("2.Cat");
        System.out.println("3.Parrot");
        System.out.println("4.Owner");
        System.out.println("5.List pets");

        int choice = scanner.nextInt();
        List<Pet> pet = new ArrayList<>();

        Owner owner = null;

        switch (choice) {
            case 1: {
                System.out.println("Enter name: ");
                String name = scanner.next();
                System.out.println("Enter age: ");
                int age = scanner.nextInt();
                System.out.println("Enter skill: ");
                String skill = scanner.next();
                System.out.println("Enter weight: ");
                double weight = scanner.nextDouble();
                System.out.println("is Hungry?");
                boolean isHungry = scanner.nextBoolean();
                System.out.println("Enter mood: ");
                String mood = scanner.next();
                System.out.println("enter tricks (comma separated): ");
                String trickInput = scanner.next();
                System.out.println("is active?");
                boolean isSleep = scanner.nextBoolean();
                List<String> tricks = Arrays.asList(trickInput.split(","));
                Dog dog = new Dog(name, age, skill, weight,mood,isHungry,tricks,isSleep);
                if (owner != null) {
                    owner.addPet(dog);
                }
                pet.add(dog);
                break;
            }
            case 2: {
                System.out.println("Enter name: ");
                String name = scanner.next();
                System.out.println("Enter age: ");
                int age = scanner.nextInt();
                System.out.println("Enter skill: ");
                String skill = scanner.next();
                System.out.println("Enter weight: ");
                double weight = scanner.nextDouble();
                System.out.println("is Hungry?");
                boolean isHungry = scanner.nextBoolean();
                System.out.println("Enter mood: ");
                String mood = scanner.next();
                System.out.println("enter tricks (comma separated): ");
                String trickInput = scanner.next();
                System.out.println("is active?");
                boolean isSleep = scanner.nextBoolean();
                List<String> tricks = Arrays.asList(trickInput.split(","));
                Cat cat = new Cat(name, age, skill, weight,mood,isHungry,tricks,isSleep);
                if (owner != null) {
                    owner.addPet(cat);
                }
                pet.add(cat);
                break;
            }
            case 3: {
                System.out.println("Enter name: ");
                String name = scanner.next();
                System.out.println("Enter age: ");
                int age = scanner.nextInt();
                System.out.println("Enter skill: ");
                String skill = scanner.next();
                System.out.println("Enter weight: ");
                double weight = scanner.nextDouble();
                System.out.println("is Hungry?");
                boolean isHungry = scanner.nextBoolean();
                System.out.println("Enter mood: ");
                String mood = scanner.next();
                System.out.println("enter vocabulary (comma separated): ");
                String trickInput = scanner.next();
                System.out.println("is active?");
                boolean isSleep = scanner.nextBoolean();
                List<String> vocabulary = Arrays.asList(trickInput.split(","));
                Parrot parrot = new Parrot(name, age, skill, weight,mood,isHungry,vocabulary,isSleep,vocabulary);
                if (owner != null) {
                    owner.addPet(parrot);
                }
                pet.add(parrot);
                break;
            }
            case 4: {
                System.out.println("Please register an owner first!");
                System.out.println("Enter owner name: ");
                String ownerName = scanner.next();
                System.out.println("Enter email: ");
                String email = scanner.next();
                owner = new Owner(ownerName, email);
                owner.listPets();
                break;
            }
            case 5: {
                if (owner != null) {
                    owner.listPets();
                } else {
                    System.out.println("No owner found. Please create one first.");
                }
                break;
            }
            default:
                System.out.println("Invalid choice!");

        }
    }
}
