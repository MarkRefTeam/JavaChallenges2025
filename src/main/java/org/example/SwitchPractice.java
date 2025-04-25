package org.example;

public class SwitchPractice {

    public static String getPlanetName(int number) {
        switch (number) {
            case 1:
                return "Mercury";
            case 2:
                return "Venus";
            case 3:
                return "Earth";
            case 4:
                return "Mars";
            case 5:
                return "Jupiter";
            case 6:
                return "Saturn";
            case 7:
                return "Uranus";
            case 8:
                return "Neptune";
            case 9:
                return "Pluto";
            case 0:
                return "Unknown";
            default:
                return "Not a planet";
        }
    }

    public static String monthOfTheSeason(int monthnumber) {
        switch (monthnumber) {
            case 1:
            case 2:
            case 12:
                return "Winter";
            case 3:
            case 4:
            case 5:
                return "Spring";
            case 6:
            case 7:
            case 8:
                return "Summer";
            case 9:
            case 10:
            case 11:
                return "Autumn";
            default:
                return "Unknown";
        }
    }
}


