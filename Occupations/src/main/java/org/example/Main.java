package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Person person = new Person(37,"Mark",Gender.Man);
        //System.out.println(person);
        //person.introduce();
        //person.printGoal();

        Chef chief = new Chef("Mark",37,Gender.MAN,8,true);
        chief.introduce();
        chief.printGoal();
        System.out.println();
        System.out.println("---- Chief Actions ----");
        System.out.println(chief.cook("Gulyas"));
        chief.leadMeeting();
        System.out.println("------------------------");

        List<Person> people = new ArrayList<>();

        people.add(new Person(25,"Raul",Gender.MAN,true));
        people.add(new Person(18,"Veronica",Gender.WOMAN,false));
        people.add(new Person(27,"Rio",Gender.MAN,true));
        people.add(new Person(33,"Martin",Gender.MAN,false));
        people.add(new Person(44,"Sofia",Gender.WOMAN,false));

        List<Chef> chiefs = new ArrayList<>();

        chiefs.add(new Chef("Claire", 40, Gender.WOMAN,8,false));
        chiefs.add(new Chef("Bob", 41, Gender.MAN,5,true));
        chiefs.add(new Chef("Tom", 42, Gender.MAN,3,true));
        chiefs.add(new Chef("Nikita", 43, Gender.WOMAN,4,false));
        chiefs.add(new Chef("Carla", 44, Gender.WOMAN,7,false));

        System.out.println("=== People ===");
        for(Person person : people) {
            person.introduce();
            person.printGoal();
            System.out.println();
        }

        System.out.println("=== Chiefs ===");
        for(Chef c : chiefs) {
            c.introduce();
            c.printGoal();
            System.out.println(chief.cook("Spaghetti"));
            c.leadMeeting();
            System.out.println();
        }
    }
}
