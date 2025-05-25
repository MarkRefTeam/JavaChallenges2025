package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Person person = new Person(37,"Mark",Gender.Man);
        //System.out.println(person);
        //person.introduce();
        //person.printGoal();

        Chief chief = new Chief("Mark",37,Gender.Man,8,true);
        chief.introduce();
        chief.printGoal();
        System.out.println();
        System.out.println("---- Chief Actions ----");
        System.out.println(chief.cook("Gulyas"));
        chief.leadMeeting();
        System.out.println("------------------------");

        List<Person> people = new ArrayList<>();

        people.add(new Person(25,"Raul",Gender.Man,true));
        people.add(new Person(18,"Veronica",Gender.Woman,false));
        people.add(new Person(27,"Rio",Gender.Man,true));
        people.add(new Person(33,"Martin",Gender.Man,false));
        people.add(new Person(44,"Sofia",Gender.Woman,false));

        List<Chief> chiefs = new ArrayList<>();

        chiefs.add(new Chief("Claire", 40, Gender.Woman,8,false));
        chiefs.add(new Chief("Bob", 41, Gender.Man,5,true));
        chiefs.add(new Chief("Tom", 42, Gender.Man,3,true));
        chiefs.add(new Chief("Nikita", 43, Gender.Woman,4,false));
        chiefs.add(new Chief("Carla", 44, Gender.Woman,7,false));

        System.out.println("=== People ===");
        for(Person person : people) {
            person.introduce();
            person.printGoal();
            System.out.println();
        }

        System.out.println("=== Chiefs ===");
        for(Chief c : chiefs) {
            c.introduce();
            c.printGoal();
            System.out.println(chief.cook("Spaghetti"));
            c.leadMeeting();
            System.out.println();
        }
    }
}
