package org.example.validator;

public class EmailValidator implements Validator<String> {

    @Override
    public boolean validate(String email) {
        return email != null && email.contains("@");
    }
}
