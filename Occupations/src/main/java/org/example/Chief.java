package org.example;

public class Chief extends Person {

    private int numberOfPeopleManaged;

    public Chief(String name,int age,Gender gender, int numberOfPeopleManaged,boolean isRentable) {
        super(age,name,gender,isRentable);
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
