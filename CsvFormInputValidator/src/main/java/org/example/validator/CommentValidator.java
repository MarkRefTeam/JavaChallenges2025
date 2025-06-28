package org.example.validator;

public class CommentValidator {

    public boolean isValid(String input) {
        //return comment != null && !comment.trim().isEmpty();
        return input != null && input.matches("^[a-zA-Z0-9 \\-_!?,.$]+$");
    }
}
