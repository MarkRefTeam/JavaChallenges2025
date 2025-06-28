package org.example.validator;

public class ValidatorService {
    public static boolean isValid(String username, String email, String comment) {
        return new UserNameValidator().isValid(username) &&
                new EmailValidator().isValid(email) &&
                new CommentValidator().isValid(comment);
    }
}
