package org.example;

import org.example.validator.UserNameValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserNameValidatorTest {

    UserNameValidator validator = new UserNameValidator();

    @Test
    void validUsernameShouldReturnTrue() {
        assertTrue(validator.isValid("john_doe"));
    }

    @Test
    void usernameWithSpecialCharShouldReturnFalse() {
        assertFalse(validator.isValid("john@doe"));
    }

    @Test
    void nullUsernameShouldReturnFalse() {
        assertFalse(validator.isValid(null));
    }
}
