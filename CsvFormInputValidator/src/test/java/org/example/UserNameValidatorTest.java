package org.example;

import org.example.validator.UserNameValidator;
import org.example.validator.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserNameValidatorTest {

    Validator<String> validator = new UserNameValidator();

    @Test
    void validUsernameShouldReturnTrue() {
        assertTrue(validator.validate("john_doe"));
    }

    @Test
    void usernameWithSpecialCharShouldReturnFalse() {
        assertFalse(validator.validate("john@doe"));
    }

    @Test
    void nullUsernameShouldReturnFalse() {
        assertFalse(validator.validate(null));
    }
}
