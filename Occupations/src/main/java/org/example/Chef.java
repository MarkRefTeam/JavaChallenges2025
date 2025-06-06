package org.example;

public class Chef extends Person {

    private int numberOfPeopleManaged;

    public Chef(String name, int age, Gender gender, int numberOfPeopleManaged, boolean isOpenToWork) {
        super(age,name,gender,isOpenToWork);
        this.numberOfPeopleManaged = numberOfPeopleManaged;
    }

    public String cook(String food) {
        return name + " has cooked some " + food + ".";
    }

    public void leadMeeting() {
        System.out.println(name + " is leading a meeting with " + numberOfPeopleManaged + " people.");
    }

    @Override
    public void introduce() {
        System.out.println("Hi , my name is " + name + ". I am " + age + ". I am a " + gender);
    }
}
