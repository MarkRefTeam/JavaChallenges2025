package org.example;

public class IfElsePractice {

    public static String categorizeAge(int age) {
        if (age < 0) {
            return "Invalid Age";
        } else if (age < 13) {
            return "Child";
        } else if (age < 18) {
            return "Teenager";
        } else if (age < 25) {
            return "Adult";
        } else if (age < 65) {
            return "Pensioner";
        } else if (age < 500) {
            return "Connor Macleod";
        } else if (age < 10_000) {
            return "God or AI";
        } else {
            return "Unknown";
        }
    }

    public static String getDayName(int dayNumber) {
        if (dayNumber < 1) {
            return "Monday";
        } else if (dayNumber < 2) {
            return "Tuesday";
        } else if (dayNumber < 3) {
            return "Wednesday";
        } else if (dayNumber < 4) {
            return "Thursday";
        } else if (dayNumber < 5) {
            return "Friday";
        } else if (dayNumber < 6) {
            return "Saturday";
        } else if (dayNumber < 7) {
            return "Sunday";
        } else {
            return "Invalid Day";
        }
    }

    public static String classifyTemperature(int temp) {
        if (temp < 0) {
            return "Freezing";
        } else if (temp <= 10) {
            return "Cold";
        } else if (temp <= 20) {
            return "Cool";
        } else if (temp <= 30) {
            return "Warm";
        } else if (temp <= 40) {
            return "Hot";
        } else if (temp < 600) {
            return "Extremely hot";
        } else if (temp < 10_000) {
            return "Welcome in the Jupiter";
        } else {
            return "Armageddon";
        }
    }

    public static String evaluateGrade(int score) {
        if (score > 100 || score < 0) {
            return "Invalid Score";
        } else if (score >= 90) {
            return "Excellent";
        } else if (score >= 80) {
            return "Very Good";
        } else if (score >= 70) {
            return "Good";
        } else if (score >= 60) {
            return "Pass";
        } else {
            return "Fail";
        }
    }
}

