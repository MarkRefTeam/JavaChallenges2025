package org.example;

import java.util.ArrayList;
import java.util.List;


public class Owner {

    String name;
    String email;
    List<Pet> pets;

    public Owner(String name, String email) {
        this.name = name;
        this.email = email;
        pets = new ArrayList<>();
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    void listPets() {
        System.out.println("Owner: " + getName());
        if(pets.isEmpty()) {
            System.out.println(name + " has no pets yet.");
        } else {
            for (Pet pet : pets) {
                System.out.println(pet.getName() + " the " + pet.getClass().getSimpleName());
            }
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Owner: ").append(name).append(" (").append(email).append(")\n");
        if(pets.isEmpty()) {
            sb.append("No pets.");
        } else {
            for (Pet pet : pets) {
                sb.append("- ").append(pet.getName()).append("\n");
            }
        }
        return sb.toString();
    }


}
