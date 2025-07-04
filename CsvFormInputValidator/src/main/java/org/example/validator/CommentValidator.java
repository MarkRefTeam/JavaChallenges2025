package org.example.validator;

public class CommentValidator implements Validator<String> {

    @Override
    public boolean validate(String input) {
        return input != null && input.matches("^[a-zA-Z0-9 \\-_!?,.$]+$");
    }
}
