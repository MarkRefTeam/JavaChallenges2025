package org.example.validator;

public class ValidatorService {
    public static boolean isValid(String username, String email, String comment) {
        return new UserNameValidator().validate(username) &&
                new EmailValidator().validate(email) &&
                new CommentValidator().validate(comment);
    }
}
