package org.example.validator;

public class EmailValidator {

    public boolean isValid(String email) {
        return email != null && email.contains("@");
    }
}
