package org.example.validator;

public class UserNameValidator {

    public static boolean isValid(String input) {
        //return username != null && username.length() >= 3;
        return input != null && input.matches("^[a-zA-Z0-9_]+$");
    }
}
